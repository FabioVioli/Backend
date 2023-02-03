package exam;

public class RegistrazioneAudio extends ElementoMultimediale implements Volume{

		private int durata;
		private int volume;
		public RegistrazioneAudio(String titolo, int durata, int volume) {
			super(titolo);
			this.durata = durata;
			this.volume = volume;
		}	
		
		
		// GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER  ++  GETTER/SETTER
		
		
		public int getDurata() {
			return durata;
		}


		public int getVolume() {
			return volume;
		}


		public void setVolume(int volume) {
			this.volume = volume;
		}
		
		
		// METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS  ++  METHODS
		
		// PLAY
		
		public void play() {
			
			for(int i = 0; i < durata; i++) {
				String volumeAudio = "";
				for(int y = 0; y < volume; y++) {
					volumeAudio += "!";
				}
				
				System.out.println(titolo + volumeAudio);
			}
		}
		
		// ALZA IL VOLUME 

		public void alzaVolume() {
		
			if(volume < 5) {
				volume++;
				System.out.println("Volume impostato a " + volume);
			}else if(volume == 5) {
				System.out.println("Volume Massimo");
			}
			
		}

		// ABBASSA IL VOLUME 
		
		public void abbassaVolume() {
			if(volume > 0) {
				volume--;	
				System.out.println("Volume impostato a " + volume);
			}else if ( volume == 0) {
				System.out.println("Volume Minimo");
			}
			
		}
		
}
