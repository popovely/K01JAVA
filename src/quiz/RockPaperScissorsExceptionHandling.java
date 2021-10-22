package quiz;

import java.util.Random;
import java.util.Scanner;

/*
가위바위보 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오
- 숫자대신 문자를 입력할 경우 발생되는 예외를 처리하시오.
  (가위바위보 입력시, 재시작여부 입력시)
- 게임과 관련없는 숫자를 입력했을때 사용자정의 예외클래스를 통해 처리하시오.

예외처리 클래스명 : WrongNumberException
 */
class WrongNumberException extends Exception {
	public WrongNumberException() {
		super("해당 숫자를 정확히 입력하세요!");
	}
}

public class RockPaperScissorsExceptionHandling
{
	public static void main(String[] args)
	{
		System.out.println("가위바위보를 입력하세요.");
		System.out.print("가위(1), 바위(2), 보(3)=>");
		
		try {
			int num = rockPaperScissorsGame();
		} catch (WrongNumberException e) {
			e.getMessage();
		}
	}
	
	public static int rockPaperScissorsGame() throws WrongNumberException {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int inputNum = 0;
		int gameCount = 0;
		
		while(true) {
			int com = random.nextInt(10000) % 3 + 1;
			System.out.println("컴퓨터:"+ com);
			/*
			가위바위보
			 */
			//문자 입력시 예외처리
			try {
				inputNum = scanner.nextInt();
			}
			catch(Exception e) {
				System.out.println("문자가 아닌 숫자를 입력하세요.");
				e.printStackTrace();
				scanner.nextLine();
			}
			//관련없는 숫자 예외처리
			try {
				if(!(inputNum>=1 && inputNum<=3)) {
					WrongNumberException ex = new WrongNumberException();
					throw ex;
				}
			}
			catch(WrongNumberException e) {
				System.out.println(e.getMessage());
			}
			//정상적으로 입력한 경우
			if(!(inputNum<1 || inputNum>3)) {
				System.out.printf("사용자:%s, 컴퓨터:%s ", displayRPS(inputNum), displayRPS(com));	
				switch(inputNum - com) {
				case 0:
					System.out.println("비겼습니다.");break;
				case 1: case -2:
					System.out.println("이겼습니다.");break;
				case 2: case -1:
					System.out.println("졌습니다.");break;
				}
				gameCount++;	
			}
			/*
			게임재시작 여부 확인			 
			 */
			if(gameCount>=5) {
				while(true) {
					//문자 입력시 예외처리
					try {
						System.out.print("게임재시작(1), 종료(0):");
						inputNum = scanner.nextInt();
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
						System.out.println("문자가 아닌 숫자를 입력하세요.");
						e.printStackTrace();
						scanner.nextLine();	//버퍼에 남아있는 엔터키를 제거한다.
					}
					//관련없는 숫자 예외처리
					try {
						if(!(inputNum==0 || inputNum==1)) {
							WrongNumberException ex = new WrongNumberException();
							throw ex;
						}
					}
					catch(WrongNumberException e) {
						System.out.println(e.getMessage());
					}
				}
				//정상적으로 입력한 경우
				if(inputNum==0) {
					break;
				}
				else {
					System.out.println("★★ 게임 재시작 ★★");
					gameCount=0;
				}
			}
		}
		return inputNum;
	}
	
	public static String displayRPS(int n) {
		String str = "";
		switch(n) {
		case 1: str="가위";break;
		case 2: str="바위";break;
		case 3: str="보";break;
		}
		return str;
	}
}
