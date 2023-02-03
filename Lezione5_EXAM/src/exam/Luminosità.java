package exam;

public interface Luminosità {

	public static void aumentaLuminosità(int luminosità) {
		
		if(luminosità < 5) {
			luminosità++;
		}else if(luminosità == 5) {
			System.out.println("Luminosità Massima");
		}
	}
	public static void riduciLuminosità(int luminosità) {
		if(luminosità > 0) {
			luminosità--;
		}else if ( luminosità == 0) {
			System.out.println("Luminosità Minima");
		}
	}
}
