package asingle;
/*
 	     *
        * *
       * * *
      => 그림같이 만들기 
   
 */

public class Problem8 {
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				
				if(i==0 && j!=2) {
					System.out.print(" ");
					continue;
				}else if(i==1 && j!=1 && j!=3){
					System.out.print(" ");
					continue;
				}else if(i==2 && j!=0 && j!=2 && j!=4) {
					System.out.print(" ");
					continue;
				}
				
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
