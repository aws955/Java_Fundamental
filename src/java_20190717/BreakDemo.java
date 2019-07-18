package java_20190717;

public class BreakDemo {
	public static void main(String[] args) {
		int sum = 0;
		test: for (int i = 1; i <= 100; i++) {
			if (i == 6)
				break test; //test 는 label 이름. 내포된 반복문이 여러개면 이름을 설정할 수 있는데 위와 같이 하면 된다.
			/*
			 * if(i==6) { break; } 이렇게 설정하면 if 를 빠져나가게 된다. 이렇게 하면 안된다.
			 */
			sum += i;
		}
		System.out.printf("1부터 5까지 합은 %d 입니다.%n", sum);

		
		
		outter : for (int first = 2; first <= 9; first++) {
			for (int second = 1; second <= 9; second++) {
				if(first==4 && second==8) break outter;
				System.out.printf("%d * %d = %d%n", first, second, first * second);
			}
		}
	}
}
