package java_20190729;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		//문자열 연결은 String 버퍼 이용
		//불변객체 garbage 처리 되지않는다.
		//수정이 들어가면 새로운 객체를 만들어버리고 기존의 것은 Constant pool 에 들어간다.
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		//s3 += "abc"; 이런식으로는 x
		
		String ssn = "111111-1111118";
		char c = ssn.charAt(6);
		System.out.println(c);
		
		ssn = ssn.concat("abcd");
		System.out.println(ssn); //이렇게 하는 경우에도 하나의 객체를 또 만들어주는것이다.
		
		//무엇으로 끝나는지 판단해서 boolean 으로 반환
		String fileName = "abd.abc.abc.abc.dddddd.doc";
		if(fileName.endsWith("zip")) {
			System.out.println("압축파일입니다.");
		}else if(fileName.endsWith("doc")) {
			System.out.println("워드문서 입니다.");
		}else {
			System.out.println("파일입니다.");
		}
		
		//equalsIgnoreCase 대소문자 구분없이 비교
		System.out.println(fileName.equalsIgnoreCase("ABd.DOc"));
		
		int index = ssn.indexOf("-");
		System.out.println(index);
		//lastIndexOf() 는 뒤부터 찾아서 앞쪽부터 센다
		
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.lastIndexOf("."));
		
		String first = ssn.substring(0,ssn.indexOf("-")); //앞에는 포함하고 뒤에는 포함하지않는다.
		String second = ssn.substring(ssn.indexOf("-")+1); //공식 , 암기 =>특정 문자를 기준으로 왼쪽 오른쪽으로 나누는 코딩
		System.out.println(first);
		System.out.println(second);
	}
}
