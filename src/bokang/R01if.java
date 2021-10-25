package bokang;

import java.util.Scanner;

public class R01if {

	public static void main(String[] args) {
		
		//if문을 단독으로 사용할 때
		int num1 = 10;
		int num2 = 20;
		if(num1<num2) {	//조건이 true일때 해당 구문이 실행됨.
			System.out.println("num1이 num2보다 작다");
		}
		
		//위 문장을 if~else문으로 변경하면
		if(num1>num2) {
			System.out.println("num1이 더 크다.");
		}
		else {
			System.out.println("num2가 더 크다.");
		}
		/*
		주의]
		else문에는 조건이 들어가지 않는다.
		조건은 항상 if문에만 들어가야 한다.
		 */
		
		/*
		[시나리오]
		90점이상 : A학점
		80~90점 미만 : B학점
		70~80점 미만 : C학점
		나머지는 F학점
		
		 - 점수의 구간같은 경우에는 이상, 이하에 해당하는 두 조건을
		   묶어주는게 안전하다.
		   
		   아래와 같이 구간을 조건식으로 묶으면 위치에 상관없이
		   해당 조건식의 사용이 가능하므로 좀 더 유연한 코딩이 가능하다.
		 */
		int score = 85;
		if(score>=90) {
			System.out.println("A학점");
		}
		else if(score>=70 && score<80) {
			System.out.println("C학점");
		}
		else if(score>=80 && score<90) {
			System.out.println("B학점");
		}
		else {
			System.out.println("F학점");
		}
		/*
		switch문
		 : if문과 같은 조건문.
		   다른점은 if문은 조건식이 들어가지만 switch문은 산술식이 들어간다.
		   
		Ex) 메뉴선택 (ex20io.E12MyFriendInfo)
		 */
		/*
		[시나리오]
		월에 해당하는 1~12까지의 숫자를 입력받아서 봄(3~5), 여름(6~9), 가을(10~11),
		겨울(12~2)인지 판단하는 switch~case문을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~12까지의 정수를 입력하세요:");
		int month = scanner.nextInt();
		switch (month) {
		case 3: case 4: case 5:	//if문의 or(||)조건같은 형식
			System.out.println("봄입니다.");
//			break;	//switch문에서 break를 만나면 즉시 탈출한다.
		case 6: case 7: case 8: case 9:
			System.out.println("여름입니다.");
			break;
		case 10: case 11:
			System.out.println("가을입니다.");
			break;
		case 12: case 1: case 2:
			System.out.println("겨울입니다.");
			break;
		default:
			break;
		}
		/*
		예를들어 3을 입력한 경우 해당 case에 break가 없으면,
		break문을 만나기까지의 아래의 모든 문장이 출력된다.
		따라서 해당 조건에 맞는 문장의 실행을 위해 반드시 break를 사용해야 한다.
		 */
	}
}
