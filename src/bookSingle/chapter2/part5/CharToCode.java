package bookSingle.chapter2.part5;

public class CharToCode {
	public static void main(String[] args) {
		char ch = 'A';
		int code = (int)ch;
		
		System.out.printf("%c=%d(%#X)%n", ch,code,code); //%#X = > 접두사가 붙은 16진수
		
		char hch = '가';
		System.out.printf("%c=%d(%#X) %n",hch,(int)hch,(int)hch);
		
		//유니코드를 알면 이것도 가능
		//문자를 입력하여 줘도 컴퓨터는 이를 유니코드로 바꿔서 저장한다.
		char hch1 = '\uAC00';
		char hch2 = 44032;
		System.out.println(hch1);
		System.out.println(hch2);
		
		char ch1 = '\u0041';
		char ch2 = 65;
		System.out.println(ch1);
		System.out.println(ch2);
		
	}
}
