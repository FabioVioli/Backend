package lezione10_EXAM;

public class Rivista extends OggettoBiblioteca{
	private Periodicità periodicità;

	
	public Rivista(Integer codiceISBN, String titolo, String anno, Integer pagine, Periodicità periodicità) {
		super(codiceISBN, titolo, anno, pagine);
		this.periodicità = periodicità;
	}


	public Periodicità getPeriodicità() {
		return periodicità;
	}


	@Override
	public String toString() {
		return "Rivista [periodicità:" + periodicità + ", ISBN:" + getCodiceISBN() + ", Titolo:"
				+ getTitolo() + ", Anno:" + getAnno() + ", Pagine:" + getPagine() + "]";
	}
	
	
}
