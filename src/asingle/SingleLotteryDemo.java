package asingle;

//double random = Math.random();  => 0 이상 1미만의 임의의 값을 double 로 반환한다.

public class SingleLotteryDemo {
	public static void main(String[] args) {
		SingleLottery t1 = new SingleLottery();
		
		t1.printLottery(5);
		
		int[] a={45,34,26,1,6,8};
		t1.printAscending(a);
	}

}
