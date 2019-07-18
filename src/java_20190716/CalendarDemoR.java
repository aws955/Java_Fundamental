package java_20190716;

/*
1. 날짜에 따른 요일 맞추기
	1) 1년1월1일 월요일
	2) 1년 365일 이고, 윤년일때는 366일 (윤년은 2월이 29일이 된다)
	3) 윤년은 4년마다 발생하고 그 중에서 100의 배수는 제외하고 400의 배수는 제외하지 않는다. (100,200,300년 => 28일 , 400년 =>29일)
	4) 2019년 12월 25일은 무슨 요일일까?
	5) 2018년까지 총 일수, 11월까지 총일수, 25일 더해서 7로 나눈 나머지를 구한다.
	6) 목표 날짜까지의 날짜수를 7로 나누어 나머지가 1이면 월요일이다.
*/

public class CalendarDemoR {
	public static void main(String[] args) {
		int year = 2019;
		int month = 12;
		int day = 25;
		
		int a = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		
		a+= 365-31;
		
		a+= day;
		
		int b = a%7;
		String message = null;
		
		if(b==1) {
			message = "월요일";
		}else if(b==2) {
			message = "화요일";
		}else if(b==3) {
			message = "수요일";
		}else if(b==4) {
			message = "목요일";
		}else if(b==5) {
			message = "금요일";
		}else if(b==6) {
			message = "토요일";
		}else {
			message = "일요일";
		}
		
		System.out.println(message);
	}

}
