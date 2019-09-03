package java_20190723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.lang.*; 내부적으로 import 되어 있기 때문에 String 을 사용할 수 있는것.

public class CalendarDemo {
	public static String console() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
		
	}

	public static void main(String[] args) throws IOException {
		Calendar c = new Calendar();
		while (true) {
			System.out.print("날짜를 입력하시요>");
			String readLine = console(); // 커서가 > 옆에서 깜빡 거린다. 값을 입력하고 enter 를 치면 한줄을 읽어서 반환해준다.
			if (readLine.equals("exit"))
				break;

			String[] data = readLine.split(" "); // split => 문자열의 공백을 기준으로 나누어준다. 배열로 반환
			// split메서드는 공백으로 문자열을 분리시켜 배열로 반환한다.

			// 배열의 길이로 년을 받았는지 년,월 을 받았는지 년,월,일을 받았는지 알 수 있다.
			int datalength = data.length;
			if (datalength == 1) {
				// String syear = data[0];
				int year = Integer.parseInt(data[0]); // 문자열을 int로 변환하는 메서드 , static 메서드(클래스이름.parseInt 이기 때문에)
				c.print(year);

			} else if (datalength == 2) {
				// String syear = data[0];
				// String smonth = data[1];
				int year = Integer.parseInt(data[0]); // syear 같은 변수는 한번만 쓰고 안쓸 것이기 때문에 parseInt의 괄호안에 넣어주는게 좋다.
				int month = Integer.parseInt(data[1]);
				c.print(year,month);

			} else if (datalength == 3) {
				// String syear = data[0];
				// String smonth = data[1];
				// String sday = data[2];
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				int day = Integer.parseInt(data[2]);
				c.print(year,month,day);
			}

		}
	}
}
