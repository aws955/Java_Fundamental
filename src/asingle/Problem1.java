package asingle;
/*
1. 날짜에 따른 요일 맞추기
	1) 1년1월1일 월요일
	2) 1년 365일 이고, 윤년일때는 366일 (윤년은 2월이 29일이 된다)
	3) 윤년은 4년마다 발생하고 그 중에서 100의 배수는 제외하고 400의 배수는 제외하지 않는다. (100,200,300년 => 28일 , 400년 =>29일)
	4) 2019년 12월 25일은 무슨 요일일까?
	5) 2018년까지 총 일수, 11월까지 총일수, 25일 더해서 7로 나눈 나머지를 구한다.
	6) 목표 날짜까지의 날짜수를 7로 나누어 나머지가 1이면 월요일이다.
*/
public class Problem1 {
	public static void main(String[] args) {
		int year = 2019 , month = 12 , day = 25;
		int totalDay = 0;
		
		//먼저 2018년까지의 총 일수를 구해준다
		totalDay = (year-1) * 365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		//2019년 12월까지 총 일수를 구해준다
		totalDay += 365-31;
		//2019년 12월 25일까지 총 일수를 구해준다
		totalDay += day;
		
		int t = totalDay%7;
		String m = null;
		
		switch(t) {
		case 0 : m="일요일"; break;
		case 1 : m="월요일"; break;
		case 2 : m="화요일"; break;
		case 3 : m="수요일"; break;
		case 4 : m="목요일"; break;
		case 5 : m="금요일"; break;
		case 6 : m="토요일"; break;
		default : m="없는 날짜"; 
		}
		
		System.out.printf("%d년 %d월 %d일은 %s입니다",year,month,day,m);
	}

}
