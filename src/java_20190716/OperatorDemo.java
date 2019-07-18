package java_20190716;

//ctrl+shift+f => 자동으로 줄 맞춰주기
public class OperatorDemo {
	public static void main(String[] args) {
		int a = 10, b = 22;
		int c = 0;
		double d = 0;

		c = a + b;
		System.out.println(c);

		c = a - b;
		System.out.println(c);

		c = a * b;
		System.out.println(c);

		c = b / a;
		System.out.println(c);
		// int로 선언했기 때문에 소수 자리는 cut 된다
		// 소수점 이하의 계산을 하려면 전부 실수형으로 해야한다.
		double e = 10, f = 22;
		double g = f / e;
		System.out.println(g);
		// 또는 각각 캐스팅을 해주면 실수 계산이 된다. 왼쪽은 캐스팅을 하면 안된다.
		d = (double) b / (double) a;
		System.out.println(d);

		c = b % a;
		System.out.println(c);

		a += b; // a = a+b;
		System.out.println(a);

		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i; // sum=sum+i; (복합대입연산자로 조금 더 간단히 할 수 있다.기존의 값을 설정해놓고 그 안에서 계속 계산할때)
		}
		System.out.println(sum);

		a++; // 위 a+=b 부분에서 a 의 값은 10이 아닌 32로 바뀌어 있다.
		++b; // ++ 나 --는 앞뒤에 전부 들어갈 수 있다.
		System.out.println(a++);
		System.out.println(++b); // 값을 출력할때 앞쪽에 있으면 증가하고 출력하고 뒤쪽에 있으면 출력한 뒤 증가한다. (순서의 문제)

		// 현재 a에는 34가 들어있고 b에는 24가 들어있다.
		c = a++; // 대입한 뒤에 증가한다.
		System.out.println(c);
		c = ++b; // 증가한 뒤에 대입한다.
		System.out.println(c);

		a = 10;
		b = 20;
		boolean isSuccess = false;

		isSuccess = a > b;
		System.out.println(isSuccess);

		isSuccess = a < b;
		System.out.println(isSuccess);

		isSuccess = a >= b;
		System.out.println(isSuccess);

		isSuccess = a <= b;
		System.out.println(isSuccess);

		isSuccess = a == b;
		System.out.println(isSuccess);

		isSuccess = a != b;
		System.out.println(isSuccess);

		// short circuit 이 발생하게 되면 뒷 쪽 연산을 안한다. 그래서 결과는 a=10, b=20이 나온다.
		// 만약 && 이 ||으로 바뀐다면 뒷 쪽 연산도 진행하기 때문에 a=11,b=21 이 나온다
		// &&의 경우에는 앞이 False 이면 , || 의 경우에는 앞이 True 이면 short circuit 이 발생한다.
		// a && b => a가 false 이면 b 연산을 하지않음(short circuit)
		// a || b => a가 true 이면 b 연산을 하지 않음(short circuit)
		isSuccess = a == b && ++a == b++;
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);

		System.out.println(!isSuccess); // ! 는 결과값을 반대로 바꿔준다

		System.out.println(1 + 2 + 3 + "4" + 5 + 6); // 숫자+문자를 하게되면 값이 문자열로 바뀌고 +는 연결연산자가 된다.
		System.out.println(1 + 2 + 3 + "4" + (5 + 6)); // ()을 하게되면 가장 먼저 계산 된다.
		// && 이 || 보다 먼저 연산된다.

	}
}