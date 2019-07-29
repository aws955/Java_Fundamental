package java_20190729;

public class MathDemo {
	public static void main(String[] args) {
		double d1 = Math.ceil(4.1); //올림
		System.out.println(d1);
		
		d1 = Math.floor(4.9); //내림
		System.out.println(d1);
		
		//double => long 으로 반환
		//float => int 로 반환
		long a1 = Math.round(4.6); //반올림
		System.out.println(a1);
		
		//소수 셋째자리에서 반올림
		double d2 = 42.789;
		double a2 = Math.round(d2*100);
		System.out.println(a2/100);
		
		double d3 = Math.abs(-4.2);
		System.out.println(d3);
		
		double d4 = Math.sqrt(4);
		System.out.println(d4);
		
		double d5 = Math.pow(2, 50);
		System.out.println(d5);
		
		double d6 = Math.random();
		System.out.println(d6);
	}
}
