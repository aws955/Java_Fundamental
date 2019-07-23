package java_20190723;

//Variable Arguments 도 오버로딩 된 케이스이다.
//인자의 갯수를 가변적으로 받을 수 있는 장점이 있다.
public class VarArgDemo {
	// 프로그래밍에서 초기화 => 처음 값을 할당하는 것 , default 값이 있다면 자동으로 초기화 된다고 말한다.
	// temp 는 배열로 처리함
	public long sum(int... temp) {
		long sum = 0; // 지역변수(메서드 안에서만 유효한 변수,지역변수는 자동으로 초기화 되지 않기 때문에 초기값을 할당해준다)

		for (int t : temp) {
			sum += t;
		}
		return sum;
	}

	public static void main(String[] args) {
		VarArgDemo v1 = new VarArgDemo();

		long s1 = v1.sum(1, 2);
		System.out.println(s1);

		long s2 = v1.sum(1, 2, 3, 4);
		System.out.println(s2);
	}
}
