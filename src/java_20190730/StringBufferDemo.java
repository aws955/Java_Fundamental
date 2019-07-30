package java_20190730;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		StringBuffer s2 = new StringBuffer("test");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2)); 
		//StringBuffer클래스 에서는 equals() overriding 하지 않았기 때문에
		//문자열 자체를 비교할 수 없다. 
		//toString() 을 이용하여 비교해야한다. (문자열에서 비교)
		
		String s3 = s1.toString();
		String s4 = s2.toString();
		System.out.println(s3.equals(s4));
		
		//문자열의 추가는 append() 를 이용한다.
		StringBuffer sql = new StringBuffer();
		sql.append("select name,age ");
		sql.append("from member ");
		sql.append("where name = '성영한' ");
		sql.append("order by name desc");
		System.out.println(sql);
		
		sql.setLength(0); //sql 안에 있던 모든 문자열이 다 지워진다.
		
		sql.append("select no, writer from board");
		System.out.println(sql);
		//문자열 작업을 하고 싶다면 String 으로 바꾸어 작업해준다.
	}
}
