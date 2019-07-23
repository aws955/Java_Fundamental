package asingle;

public class Atest {
	public static void change(int i,int[] j) {
		i+=20;
		j[3]=400;
	}
	public static void main(String[] args) {

		int i =10;
		int j[] = {1,2,3,4};
		System.out.println(i+","+j[3]);
		
		change(i,j);
		System.out.println(i+","+j[3]);
	}

}
