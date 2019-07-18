package java_20190717;

public class ContinueDemo {
	public static void main(String[] args) {
		
		int sum = 0;
			for (int i = 1; i <= 10; i++) {
			if (i == 6) continue; //continue 를 만나면 for문에서는 증감연산으로 가게 되고, while 에서는 조건문으로 간다.
			sum += i;
		}
		System.out.printf("1부터 5까지 합은 %d 입니다.%n", sum);

		//if(true) return   => 이하의 문장은 수행이 되지 않고 끝난다. 
		//위에서 continue 대신 return 이 들어가면 모든 수행을 종료하고 프로그램이 끝난다.
		
		outter : for (int first = 2; first <= 9; first++) {
			for (int second = 1; second <= 9; second++) {
				if(second==5) continue outter;
				System.out.printf("%d * %d = %d%n", first, second, first * second);
			}
		}
	}
}
