package java_20190724;

// 사용하는 클래스와 코딩하는 클래스를 구분하는 것이 좋다. ex) Demo 파일

public class BoxDemo {
	public static void main(String[] args) {
		
		//Box.NAME = "BOX2";
		//final 변수는 수정할 수 없다.
		
		Box b1 = new Box(); //default 생성자로 생성했기 때문에 각 변수에는 default 값이 들어가있다. 
		b1.width = 10;
		b1.height = 20;
		b1.depth = 30;
		System.out.printf("width : %d , heinght : %d , depth : %d%n", b1.width, b1.height , b1.depth);
		
		/*
		Box b2 = b1;
		b2.depth = 3000;
		이런식으로는 안한다.
		*/
				
		b1.change(b1); //Call by reference
		System.out.printf("width : %d , heinght : %d , depth : %d%n", b1.width, b1.height , b1.depth);
		
		
		// == 연산자는 reference 를 비교할때 같은 Object 를 바라보고 있는가를 판단한다.
		//같은 오브젝트를 참조하면 true, 다른 오브젝트를 참조하면 false
		Box b2 = new Box();
		b2.width = 10;
		b2.height = 20;
		b2.depth = 3000;
		System.out.println(b1==b2);
		
		b1 = b2;
		System.out.println(b1==b2);
	}
}
