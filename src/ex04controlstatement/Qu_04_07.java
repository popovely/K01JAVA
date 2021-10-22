package ex04controlstatement;

/*
문제2)
1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을 작성하시오.
단, 3과 7의 공배수인 경우 합에서 제외해야 한다.
출력의결과는 누적되는 모든 수를 콘솔에 print한다.
파일명 : Qu_04_07.java
 */
public class Qu_04_07 {

	public static void main(String[] args) {
//		int total = 0;
//		int i = 1;
//		while(i<=100) {
//			if((i%3==0||i%7==0) && !(i%21==0)) {
//				total += i;
//				if(i==3) {
//					System.out.print(i);
//				}
//				else {
//					System.out.print("+"+ i);
//				}
//			}
//			i++;
//		}
//		System.out.print("="+ total);
		
		
		//t
		int sum=0;
		//1~100까지 반본
		for(int i=1; i<=100; i++) {
			//3의배수 혹은 7의배수
			if(i%3==0 || i%7==0) {
				//3과 7의 공배수가 아닌 정수
				if(i%(3*7)!=0) {
					sum += i;	//누적합
					if(i!=99) {
						System.out.print(i+"+");
					}
					else {
						System.out.print(i);
					}
				}
			}
		}
		System.out.println("="+sum);	//결과출력
	}
}
