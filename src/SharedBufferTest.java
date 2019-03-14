// Fig. 23.13: SharedBufferTest.java
// Application with two threads manipulating an unsynchronized buffer.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		// create new thread pool with two threads
		ExecutorService executorService = Executors.newCachedThreadPool();

		// create UnsynchronizedBuffer to store ints
		Buffer sharedLocation = new UnsynchronizedBuffer();
		System.out.println( "     Accion\t\tValor\t   Suma de Producidos\t Suma de Consumidos");
		System.out.printf("     ------\t\t-----\t   ------------------\t ------------------%n%n");

		// execute the Producer and Consumer, giving each
		// access to the sharedLocation
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.shutdown(); // terminate app when tasks complete
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
} // end class SharedBufferTest
/*
 * pags 975 a 982
 */