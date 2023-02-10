package lezione10_EXAM;

public class OggettoBiblioteca {
	private Integer codiceISBN;
	private String titolo;
	private String anno;
	private Integer pagine;
	
	public OggettoBiblioteca(Integer codiceISBN, String titolo, String anno, Integer pagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.anno = anno;
		this.pagine = pagine;
	}

	public Integer getCodiceISBN() {
		return codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAnno() {
		return anno;
	}

	public Integer getPagine() {
		return pagine;
	}
	
	
}
