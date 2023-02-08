package exercise1;

public class MainProject {

	public static void main(String[] args) {
		
		SecondThread sec = new SecondThread();
		FirstThread fir = new FirstThread(); 
		sec.run();
		fir.run();
		
	}

}
