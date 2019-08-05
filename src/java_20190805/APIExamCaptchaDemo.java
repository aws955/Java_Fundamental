package java_20190805;

import java.util.Scanner;

import bonus.Utility;

public class APIExamCaptchaDemo {
	public static String console(String msg) {
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	public static void main(String[] args) {
		String id = "oNfLknOn8HZe29yhaKm9";
		String secret = "0Wehfu5B11";
		
		String key = Utility.getCaptchaKey(id,secret);
		
		boolean isSuccess = Utility.isCaptchaImage(id, secret, key);
		if(isSuccess) {
			System.out.println("이미지 확인");
			
			String value = console("이미지 결과값을 입력하세요>");
			boolean result = Utility.isCaptchaResult(id, secret, key, value);
			if(result) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		}else {
			System.out.println("입력값 재확인");
		}
	}
}
