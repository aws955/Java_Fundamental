package asingle;

// 5. 구구단을 만드는데 4*7 까지만 표현하라 

public class Problem5 {
	public static void main(String[] args) {
		outter: for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == 4 && j == 8)
					break outter;
				System.out.printf("%d * %d = %d%n", i, j, i * j);
			}
		}
	}

}
