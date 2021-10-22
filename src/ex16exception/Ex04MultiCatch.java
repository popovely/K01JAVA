package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
예외처리를 할때 필요에 따라 여러개의 catch블럭을 사용할 수 있다.
이 경우 반드시 자식 예외클래스부터 catch블럭에 사용해야한다.
Exception클래스는 모든 예외를 catch하기 때문에 마지막 블럭에 사용해야 한다.
 */
public class Ex04MultiCatch
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[3];
		
		try {
			for(int i=0; i<array.length; i++) {
				System.out.print("array["+ i +"]에 저장할 숫자입력:");
				//입력값에 "11a"와 같이 숫자가 아닌값이 포함되면 예외발생
				array[i] = Integer.parseInt(scanner.nextLine());
			}
			//나누는 값에 0을 입력하면 예외발생
			System.out.println("배열에 저장된 두 숫자나누기:"+ array[0]/array[1]);
			System.out.print("나이를 입력하세요:");
			//나이입력시 "열살"과 같이 입력하면 예외발생
			int age = scanner.nextInt();
			System.out.println("당신의 나이는:"+ age);
			//배열의 인덱스를 초과하여 예외발생
			array[3] = age;
		}
		catch(InputMismatchException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("산술연산이 불가능 합니다.");
		}
		catch(NumberFormatException e) {
			System.out.println("숫자형태의 문자만 입력가능합니다.");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다.");
		}
		catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("== 프로그램 끝 ==");
	}
}
