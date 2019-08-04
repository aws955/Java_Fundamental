package java_20190723;
// one line comment 한줄 주석
/*
 * multi line comment
 */

//Java docs comment =>이후에 API 처럼 만들면 상단의 설명이 됨
//java docs 만들시 Private 은 안보인다.
/**
 Calendar 클래스는 년도별, 월별, 요일을 구할 수 있는 클래스 입니다.
 */
public class Calendar {
	public static final int SUNDAY = 0; // final 변수는 대문자로 . static 으로 공유 . 대부분 공개(public)
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	private int getCount(int year, int month, int day) { // 내부에서만 쓰면 되기에 private
		int preYear = year - 1;
		int preMonth = month - 1;
		int totalCount = 0;

		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		boolean isLeafYear = isLeafYear(year);

		if (isLeafYear) {
			monthArray[1] = 29;
		}

		for (int i = 0; i < preMonth; i++) {
			totalCount += monthArray[i];
		}

		totalCount += day;

		return totalCount;
	}

	private boolean isLeafYear(int year) {
		return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
	}

	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		boolean isLeafYear = isLeafYear(year);

		if (isLeafYear) {
			monthArray[1] = 29;
		}

		return monthArray[month - 1];
	}
	/**
	 매개변수에 년, 월, 일로 호출하면 해당 날짜의 요일을 출력하는 기능입니다.
	 */
	public void print(int year, int month, int day) {

		int dayOfWeek = getCount(year, month, day) % 7;
		String message = null;

		if (dayOfWeek == Calendar.MONDAY) {
			message = "월요일";
		} else if (dayOfWeek == Calendar.TUESDAY) {
			message = "화요일";
		} else if (dayOfWeek == Calendar.WEDNESDAY) {
			message = "수요일";
		} else if (dayOfWeek == Calendar.THURSDAY) {
			message = "목요일";
		} else if (dayOfWeek == Calendar.FRIDAY) {
			message = "금요일";
		} else if (dayOfWeek == Calendar.SATURDAY) {
			message = "토요일";
		} else if (dayOfWeek == Calendar.SUNDAY) {
			message = "일요일";
		}

		System.out.println(year + "년 " + month + "월 " + day + "일 " + message);
	}
	/**
	 매개변수에 년도와 월로 호출하면 해당 년도의 월 달력을 출력하는 기능입니다.
	 */
	public void print(int year, int month) {
		System.out.println(year+"년"+month + "월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		// 들여쓰기 기능
		int rest = getCount(year, month, 1) % 7;
		for (int i = 0; i < rest; i++) {
			System.out.print(" \t");
		}

		int lastDay = getLastDay(year, month);
		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + " \t");
			if (rest % 7 == Calendar.SATURDAY) {
				System.out.println();
			}
			rest++;
		}
		System.out.println();
	}
	/**
	 매개변수에 년도로 호출하면 해당 년도의 월 별 달력을 출력하는 기능입니다.
	 */
	public void print(int year) {
		for (int i = 0; i < 12; i++) {
			
				print(year, i + 1);
			
		}

	}
}
