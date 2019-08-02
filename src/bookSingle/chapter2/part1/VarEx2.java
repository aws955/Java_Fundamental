package bookSingle.chapter2.part1;
//변수 x와 y 값 교환하기
public class VarEx2 {
	public static void main(String[] args) {
		int x = 10, y = 20;
		int tmp = 0;
		System.out.println("x : " + x + " y : " + y);
		
		tmp = x;
		x=y;
		y=tmp;
		System.out.println("x : " + x + " y : " + y);
	}
}
