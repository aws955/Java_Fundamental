package java_20190806;


public class RunnableDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d%n", threadName, i);
		}

		
	}

	public static void main(String[] args) {
		System.out.println("*******************start*******************");

		RunnableDemo r1 = new RunnableDemo();
		Thread t1 = new Thread(r1);
		t1.start();

		RunnableDemo r2 = new RunnableDemo(); // 객체에 오버라이딩 된 run을 수행하려면 Thread 안에 넣어줘야한다.
		Thread t2 = new Thread(r2);
		t2.start();

		System.out.println("********************end********************");
	}
}
