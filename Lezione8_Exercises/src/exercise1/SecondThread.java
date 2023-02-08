package exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecondThread extends Thread {
	
	Logger log = LoggerFactory.getLogger(SecondThread.class);
	public String sign = "*";
	
	public SecondThread() {
	
	}

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			try {
				sleep(1000);
			log.info(this.sign);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
