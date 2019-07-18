package java_20190718;

/*
-달력만들기
1. 1년1월1일 월요일
2. 1년 365일 이고, 윤년일때는 366일 (윤년은 2월이 29일이 된다)
3. 윤년은 4년마다 발생하고 그 중에서 100의 배수는 제외하고 400의 배수는 제외하지 않는다. (100,200,300년 => 28일 , 400년 =>29일)
4. 2019년 12월 25일은 무슨 요일일까?
5. 2018년까지 총 일수, 11월까지 총일수, 25일 더해서 7로 나눈 나머지를 구한다.
5. 목표 날짜까지의 날짜수를 7로 나누어 나머지가 1이면 월요일이다.
*/
public class CalendarDemo {
	public static void main(String[] args) {

		int year = 2019;
		int month = 12;
		int day = 25;

		int preYear = year - 1; // preYear => 2018년도
		int preMonth = month - 1; // preMonth => 2019년 11월
		int totalCount = 0;

		// 2018년도까지 총 일수 (윤년은 366일이기에 윤년의 수만큼 +1해야한다.)
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		// 2019년 11월까지 총 일수
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		boolean isLeafYear = year%4==0 && (year%400==0 || year%100!=0);
		
		if(isLeafYear) {
			monthArray[1] = 29;
		}
		
		for(int i=0;i<preMonth;i++) {
			totalCount += monthArray[i];
		}
		
		
		totalCount += day;
		

		int dayOfWeek = totalCount % 7;
		String message = null;

		if (dayOfWeek == 1) {
			message = "월요일";
		} else if (dayOfWeek == 2) {
			message = "화요일";
		} else if (dayOfWeek == 3) {
			message = "수요일";
		} else if (dayOfWeek == 4) {
			message = "목요일";
		} else if (dayOfWeek == 5) {
			message = "금요일";
		} else if (dayOfWeek == 6) {
			message = "토요일";
		} else {
			message = "일요일";
		}

		System.out.println(year + "년 " + month + "월 " + day + "일 " + message);
	}
}
