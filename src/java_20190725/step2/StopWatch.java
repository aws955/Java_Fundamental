package java_20190725.step2;
//기능에 따라 최대한 나누는것이 좋다.
public class StopWatch {
	long startTime;
	long endTime;

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}

	public double getElapsedTime() {
		return (double) (endTime - startTime) / (double) 1000;
	}

	long startNonoTime;
	long endNonoTime;

	public void startNano() {
		startNonoTime = System.nanoTime();
	}

	public void stopNano() {
		endNonoTime = System.nanoTime();
	}

	public double getElapsedNanoTime() {
		return (double) (endNonoTime - startNonoTime) / (double) 1000000000;
	}
}
