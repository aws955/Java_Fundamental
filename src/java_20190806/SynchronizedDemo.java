package java_20190806;

public class SynchronizedDemo implements Runnable {
	int x;
	int y;
	
	// 다른 객체를 참조할때는 synchronized 가 발동하지않는다.
	// 여러 스레드가 같은 객체를 공유할 때 사용한다.
	// 필요할때만 써야한다. thread 를 상속받는 경우에는 항상 새로운 객체로 쓰레드를 하기 때문에 필요없다.
	public synchronized void run() {
		/* 특정부분에만 필요할때.
		synchronized(this) {
			
		}
		synchronized(SynchronizedDemo.class) {
			
		}
		*/
		for (int i= 0; i<100; i++) {
			x++;
			y++;
			String threadName = Thread.currentThread().getName();
			System.out.printf("x : %d, y: %d %s%n" , x , y,threadName);
		}
	}
	
	public static void main(String[] args) {
		SynchronizedDemo s1 = new SynchronizedDemo();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1);
		
		t1.start();
		t2.start();
	}
}
