package java_20190725.step5;

public class StopWatchDemo {
	public static void execute(StopWatch s) {
		s.execute();
	}

	public static void main(String[] args) {
		execute(new StopMicroWatch());
	}
}
