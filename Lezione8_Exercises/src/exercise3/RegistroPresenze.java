package exercise3;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {
	
	static Scanner sc = new Scanner(System.in);
	static File file = new File("dirFile/test.txt");
	static Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
	
	static Set<User> list = new HashSet<User>();
	public static void main(String[] args) {
		
	

//		try {
//			scriviFile("Test di scrittura su file");
//			String testoDaFile = leggiFile();
//			System.out.println("Testo: " + testoDaFile);
//			cancellaFile();
//			cancellaDir();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		main();
	
	}

	public static void main() {
		try {
		System.out.println("Seleziona cosa fare");	
		System.out.println("1 - Aggiungi utente");
		System.out.println("2 - Vedi presenze");
		int choice = Integer.parseInt(sc.nextLine());
		
		
		switch (choice) {
		case 1: {
			try {
				scriviNome();
			} catch (IOException e) {
				log.error("Error!");
			}
			break;
		}
		case 2: {
			try {
				istanziaOggetti();
			} catch (IOException e) {	
				log.error("Error!");
			}
			break;
		}
		default:
			break;
		}
		main();
		}catch(NumberFormatException e) {
			log.error("ERROR");
			main();
		}
	}
	
	public static void scriviNome() throws IOException {
	System.out.println("Inserisci il nome");
	String nome = sc.nextLine();
	FileUtils.writeStringToFile(file, nome + " ", "UTF-8", true);
	System.out.println("Inserisci il cognome");
	String cognome = sc.nextLine();
	FileUtils.writeStringToFile(file, cognome + "@", "UTF-8", true);
	System.out.println("Inserisci presenze");
	int presenze = Integer.parseInt(sc.nextLine());
	FileUtils.writeStringToFile(file, presenze +"#", "UTF-8", true);
	}
	
	public static void istanziaOggetti() throws IOException{
		
		String str = FileUtils.readFileToString(file, "UTF-8");
		String[] parts = str.split("#");
		for (int i = 0; i< parts.length; i++) {
			
		System.out.println(parts[i]);
		String nome = parts[i].substring(0, parts[i].indexOf(" "));
		String cognome = parts[i].substring(parts[i].indexOf(" "), parts[i].indexOf("@"));
		String presenze = parts[i].substring(parts[i].indexOf("@")+1);
			
			User user = new User(nome, cognome, presenze);
			if(!list.contains(user)) {
				list.add(user);
				System.out.println(user);
			}else {
				user.setPresenze(presenze);
			}
		}
		
		clear();
		main();
		
		
	}
	
	public static void clear() {
	FileUtils.deleteQuietly(file);
}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// 3) creiamo i metodi che vogliamo. Ex: scriviFile userà il writeStringToFile()
//	public static void scriviFile(String testo) throws IOException {
//		FileUtils.writeStringToFile(file, testo, "UTF-8", false);
//		// UTF-8 caratteri latini . true / false append ( 
//		System.out.println("Testo inserito nel file");
//	}
//	
//	public static String leggiFile() throws IOException {
//		String txtFile = FileUtils.readFileToString(file, "UTF-8");
//		return txtFile;
//	}
//	
//	public static void cancellaFile() {
//		FileUtils.deleteQuietly(file);
//		System.out.println("File eliminato");
//	}
//	
//	public static void cancellaDir() throws IOException {
//		File file = new File("dirFile/"); // nota che occorre solo la dir
//		FileUtils.deleteDirectory(file);
//		System.out.println("Directory Eliminato");
//	}
//	
//	

}
