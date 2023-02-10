package lezione10_EXAM;

public class Libro extends OggettoBiblioteca {
	
	private String autore;
	private String genere;
	
	public Libro(Integer codiceISBN, String titolo, String anno, Integer pagine, String autore, String genere) {
		super(codiceISBN, titolo, anno, pagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public String toString() {
		return "Libro [Autore:" + autore + ", Genere:" + genere + ", ISBN:" + getCodiceISBN()
				+ ", Titolo:" + getTitolo() + ", Anno:" + getAnno() + ", Pagine:" + getPagine()
				 + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

