package bokang;

public class R02for {

	public static void main(String[] args) {
		
		/*
	 	while문
	 	 : 반복의 횟수가 명확하지 않을때 주로 사용하는 반복문.
	 	
	 	형식]
	 		반복을위한변수;
	 		while(반복조건) {
	 			실행문;
	 			탈출을 위한 증감식;
		 */
		//[시나리오] 1~10까지의 합을 구하는 while문을 작성하시오.
		int a = 1;
		int total = 0;
		while(a<=10) {
			total += a;
			a++;
		}
		System.out.println("1~10까지의합:"+ total);
		
		
		/*
	 	do~while문
	 	 : while문과는 다르게 일단 한번은 실행한 후 탈출을 위한 조건을 체크한다.
	 	
	 	형식]
	 		반복을 위한 초기값;
	 		do {
	 			실행문;		//해당 실행문은 무조건 1번은 실행된다.
	 			증감식;
	 		} while(조건식);
		 */
		//[시나리오] 위에서 만든 수열문제를 do~while문으로 변경하시오.
		int b = 1;
		int sum = 0;	
		do {
			sum += b;
			b++;
		} while(b<=10);
		System.out.println("1~10까지의합:"+ sum);
		
		
		/*
	 	for문 : 반복의 횟수가 명확할때 사용하는 반복문
	 	
	 	형식]
	 		for(초기값; 조건식; 증감식) {
	 			실행문장;
	 		}
		 */
		//[시나리오] 앞에서 만든 수열문제를 for문으로 변경하시오.
		int hap = 0;
		for(int i=1; i<=10; i++) {
			hap += i;
		}
		System.out.println("1~10까지의합:"+ hap);
		
		
		/*
		[연습문제]
		두개의 주사위를 던졌을때 눈의 합이 6이되는 경우를
		모두 출력하는 프로그램을 for문과 if문을 이용하여 작성하시오.
		실행결과]
			1+5=6
			2+4=6
			.......
			5+1=6
		 */
		//주사위1 (1~6까지)
		System.out.println("for문으로 주사위문제 구현하기");
		for(int i=1; i<=6; i++) {
			//주사위2 (1~6까지)
			for(int j=1; j<=6; j++) {
				//두 주사위의 합이 6이될때만 출력하기
				if(i+j==6) {
//					System.out.println(i +"+"+ j +"="+ (i+j));		//출력방법1
					System.out.printf("%d + %d = %d\n", i, j, i+j);	//출력방법2
				}
			}
		}
		
		
		/*
		[연습문제]
		위의 문제를 while문으로 변경하시오.
		 */
		System.out.println("while문으로 주사위문제 구현하기");
		int i=1;
		//주사위1은 i를 통해 반복
		while(i<=6) {
			int j=1;	/*	i를 선언하는 93라인에서 j를 같이 선언하면
			 				결과가 제대로 나오지 않는다.			*/
			//주사위2는 j를 통해 반복
			while(j<=6) {
				if(i+j==6) {
					System.out.printf("%d + %d = %d\n", i, j, i+j);
				}
				j++;
			}
			i++;
		}
		
		
		/*
		[연습문제]
		위의 문제를 do~while문으로 변경하시오.
		 */
		System.out.println("do~while문으로 주사위문제 구현하기");
		int k=1;
		do {
			int l=1;
			do {
				if(k+l==6) {
					System.out.printf("%d + %d = %d\n", k, l, k+l);
				}
				l++;
			} while(l<=6);
			
			k++;
		} while(k<=6);
		
		
		/*
		[시나리오]
		방정식 2x+4y=12를 만족하는 모든 x,y값을 구하시오.
		단, x,y의 범위는 0~10사이의 정수이고 while문을 통해 구현하시오.
		
		실행결과]
			x=0, y=3
			x=2, y=2
			.......
		 */
		System.out.println("방정식을 만족하는 x,y를 while문으로 찾기");
		//1. x와 y를 통해 각각 0~10까지 반복하는 while문을 중첩해서 만든다.
		int x=0;
		while(x<=10) {
			int y=0;
			while(y<=10) {
				//2. 문제의 방정식을 아래와같은 조건식으로 변경
				if((2*x)+(4*y)==12) {
					//3. 조건을 만족하는 x, y를 출력
					System.out.printf("x=%d, y=%d\n", x, y);
				}
				y++;
			}
			x++;
		}
		
		
		/*
		[연습문제]
		앞의 방정식 문제를 for문으로 변경하시오.
		 */
		System.out.println("방정식을 만족하는 n, m을 for문으로 찾기");
		for(int n=0; n<=10; n++) {
			for(int m=0; m<=10; m++) {
				if((2*n)+(4*m)==12) {
					System.out.printf("n=%d, m=%d\n", n, m);
				}
			}
		}
	}
}
