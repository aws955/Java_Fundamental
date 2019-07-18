package java_20190716;

public class SsnDemo {
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
		int b7 = 0;

		// 1. 각 자리수를 2부터 9 까지 곱하고 다시 2부터 5까지 곱해서 합을 구한다.
		int sum = a1 * 2 + a2 * 3 + a3 * 4 + a4 * 5 + a5 * 6 + a6 * 7 + b1 * 8 + b2 * 9 + b3 * 2 + b4 * 3 + b5 * 4
				+ b6 * 5;

		// 2. 총 합을 11로 나눈 나머지를 구한다.
		// sum %= 11;
		int rest = sum % 11;

		// 3. 11에서 나머지를 뺀다.
		// sum = 11 - sum;
		rest = 11 - rest;

		// 4. 3의 결과를 10으로 나눈 나머지를 구한다.
		// sum %= 10;
		rest = rest % 10;

		// 5. 4의 결과와 마지막 숫자가 같으면 정상적인 주민번호
		/*
		 * if(sum==b7) { 
		 * 		System.out.println("정상"); 
		 * }else { 
		 * 		System.out.println("비정상"); 
		 * }
		 */
		// 전부 sum 으로 하게 되면 코드는 간단해지더라도 로직을 모르는 사람이 보면 이해하기 쉽지않다.
		if (rest == b7) {
			System.out.println("정상적인 주민 번호");
		} else {
			System.out.println("비정상적인 주민 번호");
			System.out.println("정상적인 끝자리는 " + rest + " 입니다.");
			System.out.println("오늘은 그만~~");
		}
	}
}
