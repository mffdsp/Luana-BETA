package user;

public class Usuario {
	
	private String login;
	private String senha;
	
	private String nome;
	private int idade;
	private String endereco;
	private String bio;
	
	private int atualINDEX = 0;
	private String[] amigos = new String[100];
	

	public void addAmigo(String amigo) {
		
		amigos[atualINDEX] = new String();
		amigos[atualINDEX] = amigo;
		atualINDEX += 1;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}	
	

}
