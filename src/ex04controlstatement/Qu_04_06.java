package ex04controlstatement;

/*
문제1)
다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
파일명 : Qu_04_06.java

*
* *
* * *
* * * *
* * * * *

 */
public class Qu_04_06 {

	public static void main(String[] args) {
		int x=1;
		while(x<=5) {
			int y=1;
			while(y<=5) {
				if(x>=y) {
					System.out.print("* ");
				}
				y++;
			}
			System.out.println();
			x++;
		}
		
		
		//t
//		int i=1;
//		while(i<=5) {
//			int j=1;
//			while(j<=i) {
//				System.out.print("* ");
//				j++;
//			}
//			System.out.println("");
//			i++;
//		}
	}
}
