package exercise2;

public class FirstThread extends ThreadsContainer {
	
	
	@Override
	public void run() {
			
			for(int i =0; i < 4; i++ ) {
				sum1 += arrFilled.get(i).intValue();
			}
			
			log.info("Somma FirstThread: " + sum1);
			
		}
		
		public int getValue(int sum) {
			return sum;
		}
		
	

}
