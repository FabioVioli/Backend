package exercise3;

public class User {
	private String nome;
	private String Cognome;
	private String presenze;
	
	public User(String nome, String cognome, String presenze) {
		this.nome = nome;
		this.Cognome = cognome;
		this.presenze = presenze;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getPresenze() {
		return presenze;
	}

	public void setPresenze(String presenze) {
		this.presenze = presenze;
	}

	@Override
	public String toString() {
		return "User [nome= " + nome + ", Cognome= " + Cognome + ", presenze= " + presenze + "]";
	}
	
	
	
	
}
