package java_20190715;

public class CharLiteralDemo {
	public static void main(String[] args) {
		// char 1iteral의 유니코드 표현 => '\u0000'
		char c1 = '\uc548';
		char c2 = '\uc6d0';
		char c3 = '\uc11d';

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		// char 1iteral의 아스키코드 표현 => 65
		// 랜덤한 숫자 배열을 뽑아낼 때 사용 가능
		// 48부터 찍어보면 알 수 있다.
		char c4 = 65;
		System.out.println(c4);

		// char literal의 문자표현 => ' '
		char c5 = 'q';
		System.out.println(c5);

		char c6 = '\'';
		char c7 = '\\';
		char c8 = '\"'; // ' , " , \ 는 무조건 \ 을 붙여주자.

		String path = "C:\\\"dev\"\\eclipse";

		// 특수문자 (Escape character)
		// \n => 개행(line feed)
		// \t => tab
		// \\ => back slash
		// \' => single quotation
		// \" => double quotation
		String path1 = "aa\tbb";
		System.out.println(path1);

		String path2 = "aa\ncc";
		System.out.println(path2);

	}
}