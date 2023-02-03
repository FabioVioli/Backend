package exam;

public abstract class ElementoMultimediale {
	String titolo;

	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "ElementoMultimediale [titolo=" + titolo + "]";
	}
	
	
}
