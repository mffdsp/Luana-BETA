package main;

import java.util.Scanner;

import action.Action;

public class Init {
	
	Scanner input = new Scanner(System.in);
	
	public void executar() {
		
		System.out.println("1 - Efetuar Login\n2 - Realizar cadastro");
		
		int action = input.nextInt();
		
		switch(action) {
		case 1:
			new Action().singIN();
			break;
		case 2:
			new Action().singUP();
			break;
		default:
			System.out.println("Entrada incorreta!");
			executar();
		}
		
	}

}
