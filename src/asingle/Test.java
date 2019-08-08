package asingle;

class Point2D{ 
 public void disp(){ 
    System.out.println("Point2D의 disp()"); 
 } 
} 



class Point3D extends Point2D{ 
 private String name; 
 
 // 부모 클래스가 가진 메소드를 재정의 함. 
 public void disp(){ 
    System.out.println("Point3D의 disp()"); 
 } 
 
 public String getName(){ 
    return this.name; 
 } 
 public void setName ( String name ) { 
    this.name = name; 
 } 
} 






//이 클래스는 main 메소드가 있는 클래스로 실행시 진입점이 있는 클래스 
public class Test { 
 public static void main( String[] args ) { 
   
	//1번 
    Point2D p2 = new Point2D(); 
    Point2D p2_1 = p2; 
    p2_1.disp(); 
    //System.out.println( p2_1.getName() ); // 에러 , getName() 은 Point3D에만 있다. 
    
    
    //2번(업캐스팅) 
    //상위 클래스의 reference 로 하위 클래스의 객체를 가르킬 수 있다.
    //업캐스팅의 특징 : 이때 상위 클래스의 reference 로는 하위 클래스만의 인스턴스 변수나 메서드를 사용할 수 없다.
    Point3D p3 = new Point3D(); 
    // Point2D를 상속한 하위 클래스인 Point3D를 Point2D가 reference 했으므로 
    Point2D p2_2 = p3; 
    p2_2.disp(); 
    // 서로 동일한 메소드는 가지고 있지만 그렇지 않는 get/set 메소드는 캐스팅되면서 
    // 사용할 수 없게 됨. 업캐스팅의 특징 
    // System.out.println( p2_2.getName() ); // 에러 
    
    
    //3번(다운캐스팅) 
    Point2D p2_3 = new Point3D(); 
    // Point2D를 상속한 하위 클래스인 Point3D를 Point2D가 reference 했으므로 
    Point3D p3_1 = (Point3D) p2_3; 
    p3_1.disp(); 
    // 위에서 (Point3D) p2_3 는 캐스팅으로 하위 자식인 클래스로 변경. 
    // 즉, Point2D 에서 없는 get/set 메소드 사용 가능 
    // 결론적으로 Point2D가 자기고 있지 않은 메소드 사용 가능하단 걸 알게 됨. 
    System.out.println( p3_1.getName() ); // 정상 
   
    
    //4번 
    // 자동으로 Point2D 로 캐스팅 됨. 상위 클래스는 하위 클래스가 가지는 
    // 특수성(메소드를 추가 할 수 있다) 때문에 어쩔수 없이 하위 클래스로 
    // 인스턴스화 한다 해도 없는 메소드는 get/set 메소드를 만들어 낼 수 
    // 없기 때문 
    Point2D p2_4 = new Point3D(); 
    p2_4.disp(); 
    // 위 설명때문에 getName() 메소드를 호출 할 수 없음 
    //System.out.println( p2_4.getName() ); // 에러 
 } 
} 