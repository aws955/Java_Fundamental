package asingle;

/*
3. 1) 1 부터 10까지 합 구하기
   2) 1부터 10까지 중 짝수의 합 구하기
*/
public class Problem3 {
	public static void main(String[] args) {

		int sum = 0;
		int j = 100;
		for (int i = 1; i <= j; i++) {
			sum += i;
		}
		System.out.printf("1부터 %d까지의 총 합은 %d 입니다%n", j, sum);

		int sum1 = 0;
		int a = 200;
		for (int i = 1; i <= a; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			}
		}
		System.out.printf("1부터 %d까지 숫자 중 짝수의 총 합은 %d 입니다", a, sum1);

	}
}