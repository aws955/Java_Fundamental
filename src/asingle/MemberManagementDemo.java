package asingle;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
		super();
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("***************************************************");
		System.out.println("* 1. insert 2. update 3. delete 4. search 5. exit *");
		System.out.println("***************************************************");
	}

	public String console(String msg) {
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private void run(String selectedIndex) {
		while (true) {
			String index = console("번호를 선택하세요>");
			run(selectedIndex);
			if (selectedIndex.equals("1")) {
				// insert();
				continue;
			} else if (selectedIndex.equals("2")) {
				System.out.println("update....");
				continue;
			} else if (selectedIndex.equals("3")) {
				System.out.println("delete....");
				continue;
			} else if (selectedIndex.equals("4")) {
				System.out.println("search....");
				continue;
			} else if (selectedIndex.equals("5")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("warning....");
				print();
				continue;
			}
		}
	}

	public static void main(String[] args) {

		MemberManagementDemo m1 = new MemberManagementDemo();

		m1.print();
		String selectedIndex = m1.console("번호를 선택하세요>");
		m1.run(selectedIndex);
	}
}
