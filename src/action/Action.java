package action;

import java.util.Scanner;

import command.Admin;
import main.Init;
import user.Usuario;

public class Action {
	
	boolean valid = false;
	Scanner input = new Scanner(System.in);
	String user;
	
	public void singIN() {
		
		System.out.println("Insira seu Login:");
		
		int log = -1;
		while(log == -1) {
			user = input.nextLine();
			log = busca(user);
			if(log == -1) {
				System.out.println("Login não encontrado no sistema, tente novamente:" + "\n" + "CANCEL - para cancelar");
				if(user.equals("CANCEL")) {
					System.out.println("Operação Cancelada!");
					new Init().executar();
				}
			}
		}	
		
		System.out.println("Insira sua Senha:");
		user = input.nextLine();
		while(!user.equals(Admin.usuarios[log].getSenha())) {
			
			System.out.println("Senha incorreta, tente novamente:" + "\n" + "CANCEL - para cancelar");
			user = input.nextLine();
			if(user.equals("CANCEL")) {
				System.out.println("Operação Cancelada!");
				new Init().executar();
			}
		}
		
		System.out.println("LOGADO COM SUCESSO!");
		new Init().executar();
	}

	public void singUP() {
		
		Admin.usuarios[Admin.INDEX] = new Usuario();
		System.out.println("Bem vindo ao cadastro!\nInsira os dados seguintes,\nLogin:");
		
		while(!valid) {
			user = input.nextLine();
			verificar(user);
		}		
		
		Admin.usuarios[Admin.INDEX].setLogin(user);
		System.out.println("Senha:");
		Admin.usuarios[Admin.INDEX].setSenha(input.nextLine());
		
		System.out.println("Nome de exibição:");
		Admin.usuarios[Admin.INDEX].setNome(input.nextLine());
		
		System.out.println(Admin.usuarios[Admin.INDEX].getLogin() + "\n" + Admin.usuarios[Admin.INDEX].getSenha() + "\n" + Admin.usuarios[Admin.INDEX].getNome() );
		
		Admin.INDEX += 1;
		new Init().executar();
		
	}
	
	public void verificar(String user) {
		
		valid = true;
		for(int i = 0; i < Admin.INDEX; i++) {
			if(Admin.usuarios[i] instanceof Usuario) {
				if(Admin.usuarios[i].getLogin().equals(user)) {
					valid = false;
				}
			}
		}
		
		if(!valid) {
			System.out.println("Login já utilizado, tente outro!");
		}
		
	}
	
	public int busca(String user) {
		
		for(int i = 0; i < Admin.INDEX; i++) {
			if(Admin.usuarios[i] instanceof Usuario) {
				if(Admin.usuarios[i].getLogin().equals(user)) {
					return i;
				}
			}
		}
		return -1;
	}
}