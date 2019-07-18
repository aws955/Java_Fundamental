package java_20190718;

//Math.random() 은 0 이상 1 미만의 양수를 임의로 double 값으로 반환한다.
//45를 곱하는 이유는 45에 0이상 1미만의 양수를 곱하면 0~44.xx 의 실수 값이 나온다.

public class LotteryDemo {
	public static void main(String[] args) {

		for(int k= 0;k<5;k++) {
		
		
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {

			// 매번 새로 생성되어야 하므로 for 문 안에 있어야한다.
			double random = Math.random();
			int temp = (int) (random * 45) + 1;

			if (i == 0) { // 첫번째 방 lotto[0] 은 무조건 임의의 값 temp 를 저장한다.
				lotto[i] = temp;
			} else {
				// isExisted 는 임의의 값 temp 와 이전 배열의 값을 비교했을 때 동일한 값이 있는 경우는 true, 없으면 false
				boolean isExisted = false;
				// i==1 일때 아래의 for loop는 1번 반복
				// i==2 일때 아래의 for loop는 2번 반복
				// i==3 일때 아래의 for loop는 3번 반복 ..........
				for (int j = 0; j < i; j++) {
					if (lotto[j] == temp) {
						// 새로 생성한 temp 와 이전 배열의 값을 비교해서 같은 값이 존재하면
						isExisted = true;
						break;
					}
				}

				if (!isExisted) {
					lotto[i] = temp;
				} else {
					i--; // 첫번째 for 문으로 그냥 올라가게 되면 i++ 가 되므로 i-- 해주면 원위치에서 다시 시작할 수 있다.
				}
			}

		}
		
		for(int i=0;i<lotto.length;i++) {
			for (int j = 0; j < lotto.length-(i+1); j++) {
				if(lotto[j]>lotto[j+1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + "\t");
		}
		
			System.out.println();

		}
	}

}
