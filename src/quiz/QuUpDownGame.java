package quiz;

import java.util.Random;
import java.util.Scanner;

/*
게임설명 : 업다운게임을 메소드를 이용해 구현한다.

1. 컴퓨터는 1~100사이의 숫자 하나를 생성한다.
2. 총 시도횟수는 7번을 부여한다.
3. 사용자는 7번의 시도안에 숫자를 맞춰야 한다.
4. 사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
5. 7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
6. 성공/실패 후 계속 할지를 물어보고1이면 게임 재시작, 0이면 프로그램을 종료한다.
7. 함수를 사용하여 구현한다.
8. 무한루프에 빠지게 된다면 scan.nextLine()을 활용하여
   버퍼에 남아있는 Enter키를 제거해주도록 하자.

업다운 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오.
- 숫자입력시 1~100을 벗어난 경우 사용자정의 예외클래스를 통해 처리하시오
  (클래스명 : NumberRangeException)
- 게임 재시작 / 종료 입력시 문자를 입력했을때 발생되는 예외를 처리하시오.
 */
class NumberRangeException extends Exception {
	public NumberRangeException() {
		super("▶\n1~100 사이의 숫자를 입력하셔야\n게임이 진행됩니다!\n▶");
	}
}

public class QuUpDownGame {

	public static void main(String[] args) {
		System.out.println("★업다운 게임★");
		System.out.println("1~100까지의 숫자 중 하나를 입력하세요.");
		System.out.print("입력한 숫자 : ");
		
		try {
			int num = upDownGame();
		}
		catch(NumberRangeException e) {
			e.getMessage();
		}
	}
	
	public static int upDownGame() throws NumberRangeException {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int inputNum = 0;
		int gameCnt = 0;
		
		//컴퓨터는 1~100사이의 숫자 하나를 생성
		int com = random.nextInt(100) + 1;
		//디버깅을 위한 출력
		System.out.println("\t컴퓨터 : "+ com);
		while(true) {
			boolean success = false;
			//사용자로부터 입력받음
			inputNum = scan.nextInt();
			//범위를 벗어난 경우 예외처리
			try {
				if(!(inputNum>=1 && inputNum<=100)) {
					NumberRangeException ex = new NumberRangeException();
					throw ex;
				}
			}
			catch(NumberRangeException e) {
				System.out.println(e.getMessage());
			}
			//제대로 입력한 경우
			if(com>inputNum) {
				System.out.println("↑↑↑  UP  ↑↑↑");
				gameCnt++;
			}
			else if(com<inputNum) {
				System.out.println("↓↓↓ DOWN ↓↓↓");
				gameCnt++;
			}
			else {
				System.out.println("성공!");
				success = true;
			}
			
			//총 시도횟수는 7번
			if(gameCnt>=7 || success==true) {
				if(gameCnt==7) {
					System.out.println("실패ㅠㅠ\n다시 하시겠습니까?");
				}
				//게임재시작/종료
				while(true) {
					//문자 입력시 예외처리
					try {
						System.out.print("게임재시작(1), 종료(0) : ");
						inputNum = scan.nextInt();
						if(inputNum==0 || inputNum==1) {
							break;
						}
						else {
							System.out.println("------------------------------");
							System.out.println("종료하려면   0\n재시작하려면 1\t을 입력하세요");
							System.out.println("------------------------------");
						}
					}
					catch(Exception e) {
						scan.nextLine();
						System.out.println("문자가 아닌 숫자를 입력하세요!");
						e.printStackTrace();
					}
				}
				//정상적으로 입력한 경우
				if(inputNum==0) {
					break;
				}
				else {
					System.out.println("★★ 게임 재시작 ★★");
					gameCnt=0;
				}
			}
		}
		return inputNum;
	}
}
