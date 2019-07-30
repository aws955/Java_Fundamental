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
		
		//문자열 연결
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
		
		//replaceAll 은 많이 쓴다.
		//replaceAll(String first, String second)
		//first 문자열을 second 문자열로 대체한다.
		String html = "안녕하세요\n저는 성영한입니다.\n잘 부탁드립니다."; // \n => 개행 , html 에서는 <br> 이 개행.
		html = html.replaceAll("\n", "<br>"); //html 에서는 <> 를 사용하면 에러가 발생하기 때문에 바꿔줘야한다.
		System.out.println(html);
		
		String url ="http://www.naver.com";
		String path ="/news/sdfsdf.do?id=123&cat=1010";
		//startWith(String msg) msg문자열로 시작하면 true, or false
		if(path.startsWith("/news")){
			System.out.println("뉴스페이지입니다.");
		}else if(path.startsWith("/sports")) {
			System.out.println("스포츠 페이지입니다.");
		}else {
			System.out.println("페이지가 존재하지 않습니다.");
		}
		
		//공백때문에 false 가 나온다.
		//사용자에게 값을 받을 때 사용자가 끝에 Space를 입력할 가능성이 있다.
		String m1 = "hello";
		String m2 = "hello ";
		if(m1.equals(m2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		//문자열의 길이를 확인하는 방법
		System.out.println(m1.length());
		System.out.println(m2.length());
		//trim() 뒷 공백을 잘라준다.
		if(m1.equals(m2.trim())){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//toUpperCase() 대문자로 변환
		m1 = m1.toUpperCase();
		System.out.println(m1);
		
		//toLowerCase() 소문자로 변환
		m1 = m1.toLowerCase();
		System.out.println(m1);
		
		//String.valueOf() : primitive data type을 문자열로 변환한다.
		int a= 10;
		String str = String.valueOf(a);
		
		char[] c1 = {'a','b','c'};
		String str1 = String.valueOf(c1);
		System.out.println(str1);
		
		//- 를 기준으로 쪼개라
		//특정한 문자(구분자)를 기준으로 토큰화 하는것
		//split(String delimiter) : 문자열을 구분자(delimiter)로 토큰(token)화 시키는 메서드
		String[] strArray = ssn.split("-");
		for(String temp : strArray) {
			System.out.println(temp);
		}
		
		String str2 = String.format("%,.2f",1254.12512); //이경우 오토박싱이 일어난다. primitive는 못들어가기에
		System.out.println(str2);
	}
}
