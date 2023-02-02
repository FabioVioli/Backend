package lesson4_exercise1;

public class Dipendente {
	int stipendioBase = 1000;
	int matricola;
	int stipendio;
	int importoOrarioStraordinario;
	livello livello;
	dipartimento dipartimento;
	
	public Dipendente(int matricola, dipartimento dipartimento) {
		
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = lesson4_exercise1.livello.OPERAIO;
	}

	public Dipendente(int stipendioBase, int matricola, int importoOrarioStraordinario,
			lesson4_exercise1.livello livello, lesson4_exercise1.dipartimento dipartimento) {
		this.stipendioBase = stipendioBase;
		this.matricola = matricola;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	
	// Proprietà GET 
	
	private int getStipendioBase() {
		return stipendioBase;
	}

	private int getMatricola() {
		return matricola;
	}

	private int getStipendio() {
		return stipendio;
	}

	private livello getLivello() {
		return livello;
	}

	private dipartimento getDipartimento() {
		return dipartimento;
	}

	// Proprietà SET & GET
	
	public void setDipartimento(dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public int getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(int importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	
				// STAMPA DATI DIPENDENTE
	
	public void stampaDipendente(Dipendente d) {
		 System.out.println(d.toString());
	}
	
				// PROMUOVI DIPENDENTE
	public void promuovi(Dipendente d) {
		if(d.getLivello() == lesson4_exercise1.livello.OPERAIO) {
			d.livello = lesson4_exercise1.livello.IMPIEGATO;
			d.stipendio = (int) (d.getStipendioBase() *1.2);
			System.out.println("Congratulazioni. Sei appena stato promosso a " + d.livello + ". Il tuo nuovo stipendio è di: " + d.stipendio + "€");
		}else if(d.getLivello() == lesson4_exercise1.livello.IMPIEGATO) {
			d.livello = lesson4_exercise1.livello.QUADRO;
			d.stipendio = (int) (d.getStipendioBase() *1.5);
			System.out.println("Congratulazioni. Sei appena stato promosso a " + d.livello + ". Il tuo nuovo stipendio è di: " + d.stipendio + "€");
		}else if(d.getLivello() == lesson4_exercise1.livello.QUADRO) {
			d.livello = lesson4_exercise1.livello.DIRIGENTE;
			d.stipendio = (int) (d.getStipendioBase() *2);
			System.out.println("Congratulazioni. Sei appena stato promosso a " + d.livello + ". Il tuo nuovo stipendio è di: " + d.stipendio + "€");
		}else if(d.getLivello() == lesson4_exercise1.livello.DIRIGENTE) {
			System.out.println("ERRORE!!! SEI GIÀ AL MASSIMO LIVELLO POSSIBILE! ");
		}
	}
				// CALCOLA PAGA DIPENDENTE [NO STRAORDINARIO]
	public static int calcolaPaga(Dipendente d) {
		System.out.println("Ciao Dipendente numero di matricola nr: " + d.getMatricola() + ", il tuo stipendio mensile è di: " + d.stipendio + ".");
		return d.stipendio;
	}
	
				// CALCOLA PAGA DIPENDENTE [SI STRAORDINARIO]
	public static int calcolaPagaStraordinari(Dipendente d, int oreStraordinario) {
		System.out.println("Ciao Dipendente numero di matricola nr: " + d.getMatricola() + ".");
		System.out.println("Questo mese hai effettuato " + oreStraordinario + " ore di straordinario, pagate " + d.importoOrarioStraordinario + "€ l'una. Il tuo stipendio è di: " + (d.stipendio + (d.getImportoOrarioStraordinario()*oreStraordinario)) + "€.");
		return (d.stipendio + (d.importoOrarioStraordinario * oreStraordinario));
	}
	
	@Override
	public String toString() {
		return "Dipendente [stipendioBase=" + stipendioBase + ", matricola=" + matricola + ", stipendio=" + stipendio
				+ ", importoOrarioStraordinario=" + importoOrarioStraordinario + ", livello=" + livello
				+ ", dipartimento=" + dipartimento + "]";
	}
	
	
	

}