public class Producer extends Thread {
  	private int n;
  	private Buffer prodBuf;
  	
  	public Producer (int m, Buffer buf) {
  		n = m;
  		prodBuf = buf;
    }
    
    public void run() {
    	for (int i = 0; i < n; i++) {
    		try {
    			Thread.sleep( (int) Math.random() * 100); // sleep for a randomly chosen time
    		} catch (InterruptedException e) {return;}
    		
    	    try {
    	    	prodBuf.put(i + 1); //starting from 1, not 0
    	    } catch (InterruptedException e) {return;}
    		
    	}
    }
  }
