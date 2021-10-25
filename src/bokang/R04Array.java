package bokang;

import java.util.Scanner;

public class R04Array
{

	public static void main(String[] args)
	{
		/*
		[시나리오]
		정수 10개를 저장할 수 있는 배열을 생성한 후
		반복문을 통해 1부터 순차적인 값을 입력하시오.
		 */
		int[] arr = new int[10];
		//배열 초기화
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;	//1부터 값을 채움
		}
		//배열출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
		
		
		/*
		[시나리오]
		정수 5개를 저장할 수 있는 배열을 생성한 후 숫자를 입력받아 저장하시오.
		단, 숫자가 짝수일때만 저장하도록 프로그램을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
//		int[] arr2 = new int[5];
//		for(int i=0; i<arr2.length; i++) {
//			System.out.print("숫자를 입력하세요:");
//			int inputnum = scanner.nextInt();
//			//입력된 정수가 짝수일때만 배열에 삽입
//			if(inputnum%2==0) {
//				arr2[i] = inputnum;
//			}
//		}
//		//배열출력
//		for(int i=0; i<arr2.length; i++) {
//			System.out.print(arr2[i] +" ");
//		}
		
		
		/*
		[시나리오]
		정수 5개를 저장할 수 있는 배열을 생성한 후 숫자를 입력받아 저장한다.
		단, 숫자가 짝수일때만 저장해야 하고, 5개 모두 입력되면 프로그램을 종료한다.
		 */
		int[] arr3 = new int[5];
		int index = 0;	//배열의 인덱스로 사용할 변수
		//반복횟수를 알 수 없으므로 while문을 사용
		while(true) {
			System.out.print("숫자를 입력하세요:");
			int input = scanner.nextInt();
			if(input%2==0) {
				//후위증가이므로 0번 인덱스에 삽입후 index값이 증가한다.
				arr3[index++] = input;
			}
			/*
			탈출의 조건은 짝수 5개가 모두 입력되었을때 이므로
			index가 4일때까지 배열에 입력된 후 index값이 증가해서 5가 되는 순간
			무한루프를 탈출한다.
			 */
			if(index==5) break;
		}
		//배열출력
		for(int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i] +" ");
		}
	}
}
