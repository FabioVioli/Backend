package exercise2;

public class ThirdThread extends ThreadsContainer{
	

	@Override
	public void run() {
			
			for(int i =8; i < 12; i++ ) {
				sum3 += arrFilled.get(i).intValue();
			}
			
			log.info("Somma ThirdThread: " + sum3);
			
		}
		
		
}
