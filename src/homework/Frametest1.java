package homework;

import java.awt.Frame;

/*1. 자바 GUI
 * -java.awt패키지의 클래스 이용 => 만들기가 쉬움/느리고 무거움
 * -javax.swing 패키지의 클래스 이용 => 만들기가 힘듦/빠르고 가벼움
 * 
 * -MVC 패턴 : Model-View-Controller
 * 	1)Model : 데이터를 가져와 어떤 작업을 처리하거나 처리한 작업을 저장
 * 	2)View : 데이터를 보여주는 역할
 * 	3)Controller : View 와 Model 사이의 흐름제어
 * 
 * -컴포넌트 : 화면을 구성하는 부품
 * 	1)컨테이너에 포함되어야 비로소 화면에 출력될 수 있는 GUI 객체
 * 	2)모든 GUI 컴포너트의 최상위 클래스 : java.awt.Component
 * 	3)스윙 컴포넌트의 최상위 클래스 : javax.swing.Jcomponent
 * 
 * -컨테이너 : 컴포넌트로 부터 상속받은 하나의 윈도우 영역을 의미
 * 	1)다른 컴포넌트를 포함할 수 잇는 GUI 컴포넌트
 * 	2)java.awt.Container 를 상속받음
 * 	3)다른 컨테이너에 포함될 수 있음
 * 	4)AWT 컨테이너 : Panel,Frame,Applet,Dialog,Window
 * 	5)Swing 컨테이너 : 다른 컨테이너에 속하지 않고 독립적으로 존재 가능한 컨테이너
 * 	6)최상위 컨테이너 : 다른 컨테이너에 속하지 않고 독립적으로 존재가능
 * 	7)스스로 화면에 자신을 출력하는 컨테이너 : JFrame,JDialog,JApplet
 * 	8)모든 컴포넌트는 컨테이너에 포함되어야 비로소 화면에 출력가능
 * 
 * -자주 사용하는 AWT 패키지 => java.awt / java.awt.event
 * -자주 사용하는 swing 패키지 => javax.swing / javax.colorchooser / javax.swing.event
 * 
 *2. AWT
 * -Frame(프레임)
 * 	1)응용프로그램에 윈도우를 생성하기 위해 사용
 * 	2)기본적으로 타이틀, 최소버튼, 최대버튼, 종료버튼 지원
 * 	3)상위클래스인 Window는 타이틀, 메뉴가 지원되지 않음
 * 	4)기본으로 화면에 안보이게 설정했기 때문에 반드시 setVisible(true)값으로 설정해야 화면상에 보여짐
 * 	5)만드는 방법은 Frame을 상속받아도 되고, main메소드에서 직접 작성가능
 * 		
 * 		<생성자>
 * 		Frame() : 타이틀이 빈 상태로 생성
 * 		Frame(String str) : str을 타이틀을 지정하여 프레임을 생성
 * 		
 * 		<주요 메소드>
 * 		static Frame[] getFrames() : 애플리케이션에서 생성한 모든 프레임을 리턴
 * 		MenuBar getMenuBar() : 프레임의 메뉴바를 리턴
 * 		int getState() : 프레임의 상태를 리턴
 * 		String getTitle() : 타이틀 바의 문자열을 리턴
 * 		void remove(MenuComponent m) : 프레임에서 지정한 메뉴를 제거
 * 		void setMenuBar(MenuBar mb) : 프레임의 메뉴바 지정
 * 		void setResizable(Boolean resizable) : 프레임의 크기를 사용자가 변경할 수 있게 지정
 * 		void setSize(int width,int height) : 이 컴퍼넌트의 사이즈를 width 및 height로 변경
 * 		void setVisible(boolean b) : 파라미터 b값에 응해, 이 컴퍼넌트를 표시하는지 비표시로 하는지 합니다.
 * 		void setLocation(int x, int y) : 이 컴퍼넌트를 새로운 위치로 이동
 * 		void setBounds(int x , int y, int width ,int height) : 위치와 크기를 설정
 * 
 */

public class Frametest1 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle("첫 번째 프레임 입니다.");
		f.setBounds(100,100,300,300);
		f.setVisible(true);
	}
}
