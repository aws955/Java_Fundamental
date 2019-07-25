package java_20190725;

public class Circle extends Shape {
	double r;
	
	//추상 클래스의 메서드를 꼭 오버라이딩 해줘야 오류가 안난다.
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle - draw()");
	}
}
