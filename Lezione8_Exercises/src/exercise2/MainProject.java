package exercise2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	
	public class MainProject {
	static Logger log = LoggerFactory.getLogger(ThreadsContainer.class);
	public static List<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) {
		

		
		ThreadsContainer ts = new ThreadsContainer();
		FirstThread ft = new FirstThread();
		SecondThread st = new SecondThread();
		ThirdThread tt = new ThirdThread();
		
		ts.fillArray(arr);
		ft.run();
		st.run();
		tt.run();
		int ftSum1 = ts.sum1;
		System.out.println(ts.sum1);
		int ftSum2 = ts.sum2;
		int ftSum3= ts.sum3;

		
		
		log.info("Somma totale: " +  (ftSum1 + ftSum2 + ftSum3) );
		
	}
	
	
	
}
