// Fig. 23.12: UnsynchronizedBuffer.java
// UnsynchronizedBuffer maintains the shared integer that is accessed by
// a producer thread and a consumer thread.

public class UnsynchronizedBuffer implements Buffer {
	
	private int buffer = -1; // shared by producer and consumer threads

	// place value into buffer
	public void blockingPut(int value) throws InterruptedException {
		System.out.printf("Productor escribe	%2d", value);
		buffer = value;
	}

	// return value from buffer
	public int blockingGet() throws InterruptedException {
		System.out.printf("Consumidor lee		%2d", buffer);
		return buffer;
	}
} // end class UnsynchronizedBuffer