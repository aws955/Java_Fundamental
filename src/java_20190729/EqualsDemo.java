package java_20190729;

import java.util.HashSet;

class Car{
	String modelNumber;
	String color;
	public Car(String modelNumber, String color) {
		this.modelNumber = modelNumber;
		this.color = color;
	}
	public Car() {
		
	}
	//단축키 : Alt + Shift + s => generate hashCode() and equals() 
	//비교하고 싶은것만 비교도 가능
	//hashCode() 를 오버라이딩해주지 않으면 결과는 원하는대로 나오지만 hashCode 는 다르게 나온다.
	//반드시 equals() 와 hashCode() 를 함께 오버라이딩 해주도록 하자.
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((modelNumber == null) ? 0 : modelNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (modelNumber == null) {
			if (other.modelNumber != null)
				return false;
		} else if (!modelNumber.equals(other.modelNumber))
			return false;
		return true;
	}
	*/
	
	@Override
	public String toString() {
		return "Car [modelNumber=" + modelNumber + ", color=" + color + "]";
	}
	// 디버그 할때 많이 쓰인다.
	
}
public class EqualsDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		//equals() 메서드를 오버라이딩 해줬기 때문에 가능한 이야기
		//여기서도 hashCode() 같이 오버라이딩 해줬다.
		
		Car c1 = new Car("10101010", "black");
		Car c2 = new Car("10101010", "black");
		
		// == -> c1과 c2가 같은 객체를 참조하면 true, 그렇지 않으면 false
		System.out.println(c1==c2);
		// equals -> c1과 c2가 같은 객체를 참조하면 true, 그렇지 않으면 false
		// Object 클래스의 equals
		// 보통 오버라이딩을 사용하여 객체안의 인스턴스 변수(내용물)들이 같으면 True 가 나오도록 해준다
		System.out.println(c1.equals(c2));
		
		//해쉬코드란 객체가 가지는 유일한 값. 반드시 유일한 값을 가져야 함.
		int hashCode1 = c1.hashCode();
		int hashCode2 = c2.hashCode();
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		
		//equals 메서드가 false 이면 해쉬코드 값은 다르고, True 이면 해쉬코드 값은 같다.
		Car c3 = new Car("101010","White");
		Car c4 = c3;
		System.out.println(c3 == c4);
		System.out.println(c3.equals(c4));
		
		int hashCode3 = c3.hashCode();
		int hashCode4 = c4.hashCode();
		System.out.println(hashCode3);
		System.out.println(hashCode4);
		
		//해쉬태그를 검사하여 같은 오브젝트의 경우 하나로 처리한다.
		//equals() 를 오버라이딩하면서 hashCode()를 오버라이딩 하지 않을경우 2로 카운트 된다.
		HashSet<Car> set = new HashSet<Car>();
		set.add(c1);
		set.add(c2);
		System.out.println(set.size());
		
		System.out.println(c3); 
		//c3.toString() 이 생략되어 있는것
		//원래 toString() 메서드는 레퍼런스를 출력할 때 hashCode 가 16진수로 바뀌어서 출력됨
		//오버라이딩을 하게 되면 객체안에 있는 변수들이 출력됨
	}
}
//Object 클래스에서는 equals() 메소드가 true 이면 hashcode도 같아야 하고
//equals() 메소드가 false 이면 hashcode 값도 달라야한다고 설계되어있다.
//따라서 equals() 메서드를 오버라이딩 할때 hashCode() 도 함께 오버라이딩해야한다.
//이 규칙을 지키지 않으면 부작용이 발생(Collection(HashMap, HashTable, HashSet, LinkedHashSet 등등)
