package java_20190719;
//git test
public class TwoArrayDemo {
	public static void main(String[] args) {
		
		//2차원 배열(정적)
		int [][] a = new int [3][2];
		
		a[0][0] = 10;
		a[0][1] = 20;
		
		a[1][0] = 20;
		a[1][1] = 30;
		
		a[2][0] = 50;
		a[2][1] = 60;
		
		
		for(int i=0;i<a.length;i++) {
			for(int j = 0;j<a[i].length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		//2차원 배열(동적)
		int[][] b = {{10},{30,40},{50,60,70}};
		
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		
		//enhanced for loop (c 라는 배열의 모든값을 불러오는 방법이다.)
		int[] c = {10,20,30};
		
		// 모든 인덱스를 사람이 입력할 때는 초기값 설정에 따라 모든 값이 출력 못할 수도 있다(실수의 가능성)
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		//이렇게 하면 c 배열의 모든값을 불러오기때문에 실수 할 일이 없다.
		for(int temp : c) {
			System.out.println(temp);
		}
	}

}
