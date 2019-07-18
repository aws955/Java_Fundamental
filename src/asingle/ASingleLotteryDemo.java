package asingle;

//Math.random() 은 0 이상 1 미만의 양수를 임의로 double 값으로 반환한다.
//45를 곱하는 이유는 45에 0이상 1미만의 양수를 곱하면 0~44.xx 의 실수 값이 나온다.

public class ASingleLotteryDemo {
	public static void main(String[] args) {
		
		
		int[] loto = new int[6];
		
		
		
		for(int i =0;i<loto.length;i++) {
			
			double random = Math.random();
			int temp = (int) (random * 45) + 1;
			
			loto[i] = temp;
			
			for(int j=0;j<i;j++) {
				if(loto[i]==loto[j]) {
					i--;
					break;
				}
			}
		}
		
		
		
		
		for(int i=0;i<loto.length;i++) {
			System.out.print(loto[i]+"\t");
		}
		
	}
}
