package asingle;

// 6. 구구단을 만드는데 각 단에서 *5만 빼라

public class Problem6 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 5)
					continue;
				System.out.printf("%d * %d = %d%n", i, j, i * j);
			}
		}
	}

}
