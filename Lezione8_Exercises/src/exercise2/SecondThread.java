package exercise2;

public class SecondThread extends ThreadsContainer {
	


	@Override
	public void run() {
			
			for(int i =4; i < 8; i++ ) {
				sum2 += arrFilled.get(i).intValue();
			}
			
			log.info("Somma SecondThread: " + sum2);
			
		}
		
		
}
