package java_20190809;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

class A extends Thread {
	public void run() {
		System.out.println("Thread Hello...0");
	}
}

class B implements Runnable {
	public void run() {
			System.out.println("Thread Hello1...1");
	}
}

public class GarbageDemo {
	
	public static void m (String a) {
		a += "abc";
	}
	
	// Calendar 클래스 메서드만 사용할 수 있음
	// 단, GregorianCalendar 클래스에서 overriding 된 메서드는 사용가능
	public static Calendar getInstance() {
		return new GregorianCalendar();
	}
	public static void main(String[] args) {
		A a = new A();
		a.start();

		B b = new B();
		Thread t = new Thread(b);
		t.start();

		System.out.println("aaaaa");
		
		Calendar c = new GregorianCalendar();
		//Calendar 는 추상클래스
		Calendar c1 = Calendar.getInstance();
		
		Random r = new Random();
		System.out.println(r.nextInt(10));
		
		//Dao (Data Access Object)
		CustomerDao cdao = new CustomerDao();
		
		Customer[] customers = cdao.getCustomer();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		ArrayList<Customer> al = cdao.getCustomer1();
		for (Customer customer : al) {
			System.out.println(customer.getName());
		}
		
		
		int i = 123;
		String str = String.valueOf(i);
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
	}
}

class Customer {
	String name;
	Customer(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getCustomer() {
		
	}

}

class CustomerDao{
	public Customer[] getCustomer() {
		Customer[] cs = new Customer[10];
		
		cs[0] = new Customer("성영한1");
		cs[1] = new Customer("성영한2");
		cs[2] =new Customer("성영한3");
		cs[3] = new Customer("성영한4");
		cs[4] = new Customer("성영한5");
		cs[5] = new Customer("성영한6");
		cs[6] = new Customer("성영한7");
		cs[7] = new Customer("성영한8");
		cs[8] = new Customer("성영한9");
		cs[9] = new Customer("성영한10");
		return cs;
	}
	public ArrayList<Customer> getCustomer1(){
		ArrayList<Customer> al = new ArrayList<Customer>();
		al.add(new Customer("성영한 1"));
		al.add(new Customer("성영한 2"));
		al.add(new Customer("성영한 3"));
		al.add(new Customer("성영한 4"));
		al.add(new Customer("성영한 5"));
		al.add(new Customer("성영한 6"));
		al.add(new Customer("성영한 7"));
		al.add(new Customer("성영한 8"));
		al.add(new Customer("성영한 9"));
		al.add(new Customer("성영한 10"));
		
		return al;
	}
}
























