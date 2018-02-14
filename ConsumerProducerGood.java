import java.util.*;
import java.io.*;
public class ConsumerProducerGood {

  public static void main (String [] args) {
    Buffer buf = new Buffer();
    
    // create new threads
    Thread prod = new Producer(10, buf);
    Thread cons = new Consumer(10, buf);
    
    // starting threads
    prod.start();
    cons.start();
    
    // Wait for the threads to finish
    try {
    	prod.join();
    	cons.join();
    } catch (InterruptedException e) {return;}
  }
 
} 

class Buffer {
  		private int contents;
  		private boolean empty = true;
  		
  		public synchronized void put (int i) throws InterruptedException { 
  			while (empty == false) { 	//wait till the buffer becomes empty
  				try { wait(); }
  				catch (InterruptedException e) {throw e;}
  			}
  			contents = i;
  			empty = false;
  			System.out.println("Producer: put..." + i);
  			notify();
  		} 
  		
  		public synchronized int get () throws InterruptedException {
  			while (empty == true)  {	//wait till something appears in the buffer
  				try { 	wait(); }
  				catch (InterruptedException e) {throw e;}
  			}
  			empty = true;
  			notify();
  			int val = contents;
  			System.out.println("Consumer: got..." + val);
  			return val;
  		}
}
