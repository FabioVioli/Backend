package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadsContainer extends Thread {
	
	Logger log = LoggerFactory.getLogger(ThreadsContainer.class);
	public static List<Integer> arr = new ArrayList<Integer>();
	public int sum1;
	public int sum2;
	public int sum3;
	private Random randNumber = new Random();
	
	public static List<Integer> arrFilled;
	
	
	
	
	public void fillArray(List<Integer> arr) {
			
		for (int i = 0; i < 12; i++) {
			arr.add((int)(Math.random()*100+1));
			
		}
		log.info(arr.toString());	
		arrFilled = arr;
		
	}
	
	

	





	@Override
	public String toString() {
		return "ThreadsContainer [log=" + log + ", randNumber=" + randNumber + ", toString()=" + super.toString() + "]";
	}


	




	
	
}
