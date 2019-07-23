package asingle;

public class SingleLottery {

	private int[] makeLottery() {

		int[] lottery = new int[6];

		for (int i = 0; i < lottery.length; i++) {
			lottery[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (lottery[i] == lottery[j]) {
					i--;
					break;
				}
			}
		}

		return lottery;
	}

	private int[] ascending(int[] temp) {
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] > temp[i]) {
					int save = temp[i];
					temp[i] = temp[j];
					temp[j] = save;
				}
			}
		}

		return temp;
	}
	
	public void printAscending(int[] temp) {
		ascending(temp);
		
		for(int times : temp) {
			System.out.print(times + " ");
		}
	}

	public void printLottery(int times) {
		for (int i = 0; i < times; i++) {
			int[] lottery = ascending(makeLottery());

			for (int temp : lottery) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}

}
