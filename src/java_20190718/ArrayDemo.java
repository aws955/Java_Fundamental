package java_20190718;

public class ArrayDemo {
	public static void main(String[] args) {
		
		//int 배열 선언 , 선언시 정해진 size 는 바꿀 수 없다. , 새로운 배열을 만들어서 기존의 배열을 붙여넣어야한다.
		int[] a = new int[4];
		
		//배열 할당
		a[0] = 100;
		a[1] = 200;
		a[2] = 300;
		a[3] = 400;
		
		//배열 출력
		int sum =0;
		for(int i=0;i<a.length;i++) {
			int temp = a[i];
			sum += temp;
			System.out.println(temp); 
		
		//이후에 temp 라는 변수를 가지고 쓸 목적이 있을때 선언하는것
		//int 배열에서 꺼내오는 값은 무조건 int 이다.
		
		}
		System.out.printf("배열의 총 합은 %d 입니다.%n",sum);
		
		//배열 생성과 할당이 동시에 이루어짐
		int[] b = {1000,2000,3000,4000};
		
		b[0] = 1; //배열의 값 변경(할당) , b 배열의 첫번째 칸의 값을 1로 바꿔준다.(재할당)
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
