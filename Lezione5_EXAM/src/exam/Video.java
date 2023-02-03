package exam;

public class Video extends ElementoMultimediale implements Volume, Luminosità{
	private int durata;
	private int luminosità;
	private int volume;
	
	public Video(String titolo, int durata,int volume, int luminosità ) {
		super(titolo);
		this.luminosità = luminosità;
		this.durata = durata;
		this.volume = volume;
		
	}
	
	
	// GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER
	
	
	public int getLuminosità() {
		return luminosità;
	}

	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
	}
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getDurata() {
		return durata;
	}


	// METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS
	
		// PLAY
	
	public void play() {
		
		for(int i = 0; i < durata; i++) {
			String volumeLuminosità = "";
			for(int y = 0; y < volume; y++) {
				volumeLuminosità += "!";
			}
			for(int z = 0; z < luminosità; z++) {
				volumeLuminosità += "*";
			}
			
			System.out.println(titolo + volumeLuminosità);
		}
	}		
	
		// ALZA VOLUME 
	
	
	public void alzaVolume() {
	
		if(volume < 5) {
			volume++;
			System.out.println("Volume impostato a " + volume);
		}else if(volume == 5) {
			System.out.println("Volume massimo");
		}
	}
	
		// ABBASSA IL VOLUME 

	public void abbassaVolume() {
		if(volume > 0) {
			volume--;	
			System.out.println("Volume impostato a " + volume);
		}else if ( volume == 0) {
			System.out.println("Volume minimo");
		}
		
	}

		// AUMENTA LUMINOSITÀ

	public void aumentaLuminosità() {
		
		if(luminosità < 5) {
			luminosità++;
			System.out.println("Luminosità impostata a " + luminosità);
		}else if(luminosità == 5) {
			System.out.println("Luminosità al massimo");
		}
	}

		// RIDUCI LUMINOSITÀ
	
	public void riduciLuminosità() {
		if(luminosità > 0) {
			luminosità--;	
			System.out.println("Luminosità impostata a " + luminosità);	
		}else if ( luminosità == 0) {
			System.out.println("Luminosità al minimo");			
		}
		
	}


	


		// OVERRIDE
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}


		
	


