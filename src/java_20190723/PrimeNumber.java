package java_20190723;

public class PrimeNumber {

	public void printPrimeNumber(int temp) {
		// temp => 50 이면 50이하의 소수를 모두 구하여 출력한다.

		/*for (int i = 2; i <= temp; i++) {
			int count = 0;
			for (int j = 2; j < i ; j++) {
				if (i % j == 0) {
					count ++;
					break;
				}
			}

			if (count == 0) {
				System.out.print(i + " ");
			}
		}*/

		boolean isPrimeNumber = false;
		int count = 0;
		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;
			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.printf("소수의 갯수: %s%n", count);
	}
	
	public int[] getPrimeNumber(int temp) {
		boolean isPrimeNumber = false;
		int count = 0;
		int [] array = new int [temp];
		
		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;
			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				array[count] = i;
				count++;
			}
		}
		
		int[] copyArray = new int[count];
		System.arraycopy(array,0,copyArray,0,count);
		return copyArray;
	}
	
	public void printGetPrimeNumber(int temp) {
		int[] array = getPrimeNumber(temp);
		for(int print : array) {
			System.out.print(print+" ");
		}
		System.out.println();
		System.out.print("소수의 갯수 : "+array.length);
	}
}
