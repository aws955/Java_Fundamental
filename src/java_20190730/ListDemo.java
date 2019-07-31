package java_20190730;

import java.util.ArrayList;

class Product {
	int number;
	String name;
	double price;

	public Product(int number, String name, double price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
}

public class ListDemo {
	public static void main(String[] args) {
		//ArrayList : 순서가 있고, 객체의 중복을 허용한다.
		
		//생성 방법
		ArrayList<Product> list = new ArrayList<Product>();
		
		Product p1 = new Product(1,"terra",2500);
		Product p2 = new Product(2,"신라면",1000);
		Product p3 = new Product(3,"서울우유",3000);
		Product p4 = new Product(1,"terra",2500);
		
		//할당
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		
		for(Product product : list) {
			if(product.number == 3) {
				product.price = 3500;
			}
		}
		
		
		//삭제하는방법
		//지워지면 알아서 빈자리를 채워버린다.
		//list.remove(1);
		
		//전체를 지우는 방법
		/*
		for(int i = 0; i<list.size();i++) {
			list.remove(i--);
		}
		*/
		for(int i = 0 ; i<list.size();i++) {
			Product temp = list.get(i);
			System.out.println(temp);
		}
		
	}
}
