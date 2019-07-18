package asingle;

/*
7.	*****   => 왼쪽과 같은 모양 만들기
    ****
    ***
    **
    *
*/
public class Problem7 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 1 +i; j++) {
				System.out.print("*"); // print()는 줄바꿈을 하지 않음
			}
			System.out.println();
		}
	}

}
