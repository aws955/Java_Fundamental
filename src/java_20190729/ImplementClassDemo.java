package java_20190729;

public class ImplementClassDemo {

	public static void main(String[] args) {
		InterA i = new ImplementClass();
		i.mA();
		i.mB();
		i.mC();
		System.out.println(InterA.PI); //static 이기 때문에 클래스명으로 접근가능
	}
	//JRE System Library 에서 클래스 Path 를 제공하기 때문에 객체를 만들지 않아도 import만을 이용해서 사용 가능한 것이다. (자바에서 기본으로 제공하는 클래스)
	
	// .jar => 모든 클래스 파일의 압축파일
	//자신이 만든 클래스 파일을 배포를 하기 위해서는 .jar 로 압축해야한다.
	
	//사용자가 만든 기능을 사용하기 위해 해야하는 일
	//1. .jar 를 링크를 걸어야한다. (클래스 Path 추가)
	//2. import 문을 이용하여 사용
	
	//패키지의 두가지 기능
	//1. .java 를 폴더 별로 나누려고(소스파일을 폴더로 저장)
		//-소스를 관리할 목적
		//-자바 documentation 를 폴더별 관리 가능(자바 API 같이 만드는것)
	//2. .class를 폴더 별로 나누려고(클래스파일을 폴더로 저장)
		//-배포시에 사용이 용이해짐 (패키지별로 클래스가 나눠져있기 때문에)
	
	//
	
}
