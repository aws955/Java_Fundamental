package asingle;

public class Divisor {

	private int[] getDivisor(int temp) {
		int[] a = new int[temp];
		int count = 0;
		for (int i = 1; i <= temp; i++) {
			if (temp % i == 0) {
				a[count] = i;
				count++;
			}
		}

		int[] arrayCopy = new int[count];
		System.arraycopy(a, 0, arrayCopy, 0, count);
		return arrayCopy;
	}

	public void printDiv(int temp) {
		for (int print : getDivisor(temp)) {
			System.out.print(print + " ");
		}
	}
	
	public void getDivisor(int... temp) {
		for(int i = 0; i<temp.length;i++) {
			if(i==temp.length-1) {
				printDiv(temp[i]);
				System.out.println();
			}else {
				printDiv(temp[i]);
			}
		}
	}

}
