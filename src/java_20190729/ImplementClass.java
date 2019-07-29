package java_20190729;

public class ImplementClass implements InterA {
	// 꼭 오버라이딩 되어야한다
	@Override
	public void mB() {
		// TODO Auto-generated method stub
		System.out.println("mB() 메서드");
	}

	@Override
	public void mC() {
		// TODO Auto-generated method stub
		System.out.println("mC() 메서드");
	}

	@Override //만약 InterB 와 InterC만 implement 했을때 이 문구가 없다면 에러가 지워진다.
	//mA() 라는 새로운 메서드를 선언한 것 처럼 취급된다.
	public void mA() {
		// TODO Auto-generated method stub
		System.out.println("mA() 메서드");
	}
}
