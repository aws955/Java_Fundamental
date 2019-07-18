package java_20190716;

public class IfDemo {
	public static void main(String[] args) {

		// Run Configurations => Arguments => Program arguments 에 값을 넣어준다.
		// 1 20 30 을 입력하면 args[0] = 1 , args[1] = 20 , args[2] =30이 된다.
		// 프로그램을 계속 바꾸지 않고 외부에서 값을 가져와서 실행시킬 수 있는 장점이 있다.
		// Integer.parseInt => 문자열을 int로 바꿔준다.
		int month = Integer.parseInt(args[0]);

		String season = null;
		if (month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else if (3 <= month && 5 >= month) {
			season = "봄";
		} else if (6 <= month && 8 >= month) {
			season = "여름";
		} else if (9 <= month && 11 >= month) {
			season = "가을";
		} else {
			season = "없는 계절";
		}

		System.out.println(month + "월은" + season + "입니다");
	}

}