package asingle;

//로또 번호 생성기 만들기 (중복하지 않게,Math.random() 은 0 이상 1 미만의 양수를 임의로 double 값으로 반환한다.,오름차순 정렬)

public class ASingleLotteryDemo2 {
	public static void main(String[] args) {
		
		int[] lotto = new int[6];
		
		for(int i=0;i<lotto.length;i++) {
			int temp = (int) (Math.random()*45) +1;
			
			lotto[i] = temp;
			
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
			
			for(int a=0;a<lotto.length;a++) {
				for(int b=0;b<a+1;b++) {
					if(lotto[a]) 
				}
			}
			
			
		}
	}

}
