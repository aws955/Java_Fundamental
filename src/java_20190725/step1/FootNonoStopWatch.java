package java_20190725.step1;
//고객의 요구사항
//1. 밀리세컨드로 경과 시간을 만들어 주세요....
//2. 안되겠어요. 나노세컨드로 해주세요.
public class FootNonoStopWatch {
	long startTime;
	long endTime;
	
	long startNonoTime;
	long endNonoTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/(double)1000;
	}
	
	public double getElapsedNanoTime() {
		return (double)(endNonoTime - startNonoTime)/(double)1000000000;
	}
	
	public static void main(String[] args) {
		FootNonoStopWatch f1 = new FootNonoStopWatch();
		
		f1.startNonoTime = System.nanoTime();
		
		for(long i = 0 ; i<30_000_000_000l;i++) {
			
		}
		
		f1.endNonoTime = System.nanoTime();
		
		double elapsedTime = f1.getElapsedNanoTime();
		System.out.printf("경과시간 : %.9f",elapsedTime);
	}
}
