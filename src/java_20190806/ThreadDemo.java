package java_20190806;

// 하나의 아이피로 여러 호스트가 나눠쓰는 방식의 DHCP 도 쓰레드와 비슷한것이다.

public class ThreadDemo extends Thread {
	public ThreadDemo(String threadName) {
		super(threadName); // 이름을 만들어준다.
	}


	public void run() {
		for (int i = 0; i < 1000; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d%n", threadName, i);
		}
	}

	public static void main(String[] args) {

		System.out.println("*******************start*******************");
		// 1. Thread 클래스를 상속받는다.
		// 2. run() 메서드를 overriding 한다.
		// 3. 해당 객체를 생성한다.
		// 4. 해당 객체로 start() 메서드를 호출한다.
		// ThreadDemo t1 = new ThreadDemo("첫번째 스레드");
		new ThreadDemo("첫번째 스레드").start();
		ThreadDemo t2 = new ThreadDemo("두번째 스레드");
		t2.start();
		System.out.println("********************end********************");
	
	}
}
