package java_20190722;

//다른 패키지 내에서 한정자 테스트
import java_20190722.aa.Notice;

public class Notice2Demo extends Notice {

	public static void main(String[] args) {
		Notice n1 = new Notice(); // 서로 다른 패키지의 경우에는 import 를 꼭 해줘야 한다.

		// public 은 서로 다른 패키지도 접근가능
		n1.number = 1;

		// protected 은 서로 같은 패키지 이거나 다른 패키지여도 상속받은 경우에는 접근 가능
		// n1.title = "공지사항입니다."; //상속을 받지 않았다.

		// default 는 같은 패키지 내에서 접근 가능
		// n1.hit = 0;

		// n1.regdate = "2019";
		// regdate 는 private 형태로 Notice 에 선언되어 있기 때문에
		// The field Notice.regdate is not visible 로 오류 메세지가 나오고
		// regdate 1 은 선언 자체가 안되어 있기 때문에
		// regdate1 cannot be resolved or is not a field 라고 나온다.
		// private 는 같은 클래스 내에서만 접근 가능

		// 부모 클래스인 Notice 에서 접근할 수 있는 접근 한정자는 public,protected
		Notice2Demo n2 = new Notice2Demo();
		n2.number = 1;
		n2.title = "공지사항 입니다.";

	}

}
