package codingDojang;

//1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?

//8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
//(※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 함)

public class Problem3 {
	public int getCount(int oneNumber, int range) throws Exception{
		if (oneNumber < 0 || range < 0) {
			throw new Exception("양수를 입력하십시오");
		} else {
			if(oneNumber>9) {
			throw new Exception("10보다 작은 수를 입력하십시오");
			}
		}
		
		int count = 0;
		
		for(int i = 0 ; i<=range ; i++) {
			String str = String.valueOf(i);

			for(int j = 0 ; j<str.length() ; j++) {
				if(Integer.parseInt(String.valueOf(str.charAt(j))) == oneNumber) {
					count++;
				}
			}
		}
		

		return count;
	}

	public static void main(String[] args) throws Exception {
		int result = new Problem3().getCount(8, 10000);
		System.out.println(result);
	}
}
