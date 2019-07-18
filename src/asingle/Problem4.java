package asingle;

//4. 구구단 만들기

public class Problem4 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d%n", i, j, i * j);
			}
		}
	}

}
