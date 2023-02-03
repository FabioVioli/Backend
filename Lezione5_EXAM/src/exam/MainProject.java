package exam;

import java.util.Scanner;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	

		ElementoMultimediale arr [] = new ElementoMultimediale [5];
		
		while(true) {
			System.out.println("Seleziona cosa fare [crea, esegui, cancella, test, info o quit]");
			System.out.println("**********************************");
			String str = sc.nextLine();
			
		
			switch (str) {
			
			
			// SWITCH CASE CREA
			
			
			case "crea": {
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] == null) {
							System.out.println("Cosa vuoi creare? audio, video, immagine");
							String type = sc.nextLine();
						if(type.equals("audio") ) {
							System.out.println("Definire Nome");
							String Nome = sc.nextLine();
							System.out.println("Definire Durata ( 1-5 )");
							int Durata = Integer.parseInt(sc.nextLine());
							System.out.println("Definire Volume");
							int Volume = Integer.parseInt(sc.nextLine());	
							arr[i] = new RegistrazioneAudio(Nome, Durata, Volume);
						}else if(type.equals("video")){
							System.out.println("Definire Nome");
							String Nome = sc.nextLine();
							System.out.println("Definire Durata ( 1-5 )");
							int Durata = Integer.parseInt(sc.nextLine());
							System.out.println("Definire Volume ( 1-5 )");	
							int Volume = Integer.parseInt(sc.nextLine());
							System.out.println("Definire Luminosità ( 1-5 )");	
							int Luminosità = Integer.parseInt(sc.nextLine());
							arr[i] = new Video(Nome, Durata, Volume, Luminosità);
						}else if(type.equals("immagine")) {
							System.out.println("Definire nome");
							String Nome = sc.nextLine();
							System.out.println("Definire luminosità ( 1-5 )");
							int Durata = Integer.parseInt(sc.nextLine());
							arr[i] = new Immagine(Nome, Durata);		
						}else {
							System.out.println("scelta non valida. Spazio lasciato vuoto.");
							System.out.println("**********************************");
						}
					
					}
				}
				break;
			}
					
			// SWITCH CASE ESEGUI
			
			
			case "esegui": {
				boolean x= true;
				while(x) {
				System.out.println("Seleziona il file multimediale da 1 a 5. premi 0 per uscire");
				String file = sc.nextLine();
					switch (file) {
					case "0": {
						x = false;
						break;
					}
					case "1": {
						if (arr[0] instanceof RegistrazioneAudio) {
							((RegistrazioneAudio) arr[0]).play();
						}else if(arr[0] instanceof Video) {
							((Video) arr[0]).play();
						}else if(arr[0] instanceof Immagine) {
							((Immagine) arr[0]).show();
						}
						break;
					}
					case "2": {
						if (arr[1] instanceof RegistrazioneAudio) {
							((RegistrazioneAudio) arr[1]).play();
						}else if(arr[1] instanceof Video) {
							((Video) arr[1]).play();
						}else if(arr[1] instanceof Immagine) {
							((Immagine) arr[1]).show();
						}
						break;
					}
					case "3": {
						if (arr[2] instanceof RegistrazioneAudio) {
							((RegistrazioneAudio) arr[2]).play();
						}else if(arr[2] instanceof Video) {
							((Video) arr[2]).play();
						}else if(arr[2] instanceof Immagine) {
							((Immagine) arr[2]).show();
						}
						break;
					
					}
					case "4": {
						if (arr[3] instanceof RegistrazioneAudio) {
							((RegistrazioneAudio) arr[3]).play();
						}else if(arr[3] instanceof Video) {
							((Video) arr[3]).play();
						}else if(arr[3] instanceof Immagine) {
							((Immagine) arr[3]).show();
						}
						break;
					}
					case "5": {
						if (arr[4] instanceof RegistrazioneAudio) {
							((RegistrazioneAudio) arr[4]).play();
						}else if(arr[4] instanceof Video) {
							((Video) arr[4]).play();
						}else if(arr[4] instanceof Immagine) {
							((Immagine) arr[4]).show();
						}
						break;
					}
					default:
						break;
					}
				}
				break;
			}
			
			// SWITCH CASE CANCELLA
			
			case "cancella":{
				System.out.print("Scrivi il numero del file da cancellare (1-5)");
				int track = Integer.parseInt(sc.nextLine());
				if(track == 1 || track == 2 || track == 3 || track == 4 || track == 5) {			
					arr[track-1] = null;
					System.out.println("Traccia " + track + " cancellata!");
				}else {
					System.out.println("Si è verificato un errore. Traccia non trovata.");
				}
				break;
			}
			
			
			// SWITCH CASE TEST
			
			
			case "test": {
				RegistrazioneAudio a1 = new RegistrazioneAudio("Audio 1", 2, 4);
				Immagine i1 = new Immagine("Immagine 1", 3);
				Video v1 = new Video("Video 1", 3, 5, 2);
				RegistrazioneAudio a2 = new RegistrazioneAudio("Audio 2", 5, 3);
				Video v2 = new Video("Video 2", 5, 2, 5);
				arr[0] = a1;
				arr[1] = i1;
				arr[2] = v1;
				arr[3] = a2;
				arr[4] = v2;
				
				System.out.println("L'array è stato riempito con elementi multimediali di vario tipo");
				System.out.println("**********************************");
				break;
			}
			
			
			// SWITCH CASE INFO
			
					
			case "info": {
				System.out.println("Istruzioni:");
				System.out.println("**********************************");
				System.out.println("crea:     crea in sequenza 5 files multimediali a scelta tra audio, video o immagine");
				System.out.println("esegui:   consente l'esecuzione dei dei files multimediali. Per uscire digitare 0");
				System.out.println("full:     riempie la lista di file multimediali di files multimediali. for testing purposes");
				System.out.println("cancella: cancella un file multimediale");
				System.out.println("quit:     chiude il programma");
				System.out.println("**********************************");
				break;
			}
			case "quit": {
				return;
			}
			default:
				System.out.println("Comando non valido!");
				break;
			}
			
		}
	}
	
	


}
