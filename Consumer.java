public class Consumer extends Thread {
  	private int n;
  	private Buffer consBuf;
  	
  	public Consumer (int m, Buffer buf) {
  		n = m;
  		consBuf = buf;
    }
    
    public void run() {
    	int value;
    	for (int i = 0; i < n; i++) {
    		try {
    			value = consBuf.get();
    		}  catch (InterruptedException e) {return;}
    		try {
    			Thread.sleep( (int) Math.random() * 100); // sleep for a randomly chosen time
    		} catch (InterruptedException e) {return;}
    		
    	}
    }
  }

