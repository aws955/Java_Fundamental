package asingle;

/*
2. 주민등록번호 맨 뒷자리 맞추기 (111111-1111118 로 예시)
	1) 각 자리수를 2부터 9 까지 곱하고 다시 2부터 5까지 곱해서 합을 구한다.
		1*2 + 1*3 + 1*4 + 1*5 + 1*6 + 1*7 + 1*8 + 1*9 + 1*2 + 1*3 + 1*4 + 1*5 = 58
	2) 총 합을 11로 나눈 나머지를 구한다.
		58%11 = 3
	3) 11에서 나머지를 뺀다.
		11-3 = 8
	4) 3의 결과를 10으로 나눈 나머지를 구한다.
		8%10 = 8
	5) 4의 결과와 마지막 숫자가 같으면 정상적인 주민번호
*/
public class Problem2 {
	public static void main(String[] args) {
		int a1 = 1;
		int a2 = 1;
		int a3 = 1;
		int a4 = 1;
		int a5 = 1;
		int a6 = 1;

		int b1 = 1;
		int b2 = 1;
		int b3 = 1;
		int b4 = 1;
		int b5 = 1;
		int b6 = 1;
		int b7 = 7;

		// 1)
		int sum = sum = a1 * 2 + a2 * 3 + a3 * 4 + a4 * 5 + a5 * 6 + a6 * 7 + b1 * 8 + b2 * 9 + b3 * 2 + b4 * 3 + b5 * 4
				+ b6 * 5;

		// 2)
		sum %= 11;

		// 3)
		sum = 11 - sum;

		// 4)
		sum %= 10;

		// 5)
		if (sum == b7) {
			System.out.println("올바른 주민번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민번호입니다.");
		}
	}
}
