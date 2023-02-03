package exam;

public class Immagine extends ElementoMultimediale implements Luminosità{
	private int luminosità;

	public Immagine(String titolo, int luminosità) {
		super(titolo);
		this.luminosità = luminosità;
	}

	
	// GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER
	
	
	public int getLuminosità() {
		return luminosità;
	}
	
	public int setLuminosità() {
		return luminosità;
	}

	
	
	// METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS
	
		// SHOW
	public void show() {
		
		for(int i = 0; i < luminosità; i++) {
			String livelloLuminosità = "";
			for(int y = 0; y < luminosità; y++) {
				livelloLuminosità += "*";
			}
			
			System.out.println(titolo + livelloLuminosità);
		}
	}
	
		// AUMENTA LUMINOSITÀ
	
	public int aumentaLuminosità() {
		
		if(luminosità < 5) {
			luminosità++;
			System.out.println("Luminosità impostata a " + luminosità);
		}else if(luminosità == 5) {
			System.out.println("Luminosità al massimo");
		}
		return luminosità;
	}

		// RIDUCI LUMINOSITÀ
	
	public int riduciLuminosità() {
		if(luminosità > 0) {
			luminosità--;
			System.out.println("Luminosità impostata a " + luminosità);
		}else if ( luminosità == 0) {
			System.out.println("Luminosità al minimo");
		}
		return  luminosità;
	}
}
