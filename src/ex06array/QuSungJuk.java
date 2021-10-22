package ex06array;

import java.util.Scanner;

/*
문제1) 파일명 : QuSungJuk.java
다음 조건에 맞는 프로그램을 작성하시오.
1] 학생수를 사용자로부터 입력받는다.
	-Scanner클래스 사용
2] 입력받은 학생수만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언한다.
3] 다시 학생수만큼 각 학생의 국영수 점수를 입력받아 2]에서 생성한 배열에 저장한다.
	-Scanner클래스 사용
4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
5] 이 문제는 2차원 배열을 활용하는 문제이다.

실행결과]
학생수를 입력하세요?3
학생수:3
[1번째 학생의 점수 입력]
국어점수 입력?77
영어점수 입력?78
수학점수 입력?79
[2번째 학생의 점수 입력]
국어점수 입력?82
영어점수 입력?83
수학점수 입력?84
[3번째 학생의 점수 입력]
국어점수 입력?97
영어점수 입력?98
수학점수 입력?99
==========================
NO KOR ENG MAT TOT AVG
==========================
1  77  78  79  234 78.00
2  82  83  84  249 83.00
3  97  98  99  294 98.00
==========================
 */
public class QuSungJuk {

	public static void main(String[] args) {
		//학생수를 사용자로부터 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("학생수를 입력하세요?");
		int stNum = scanner.nextInt();
		
		//입력받은 학생수만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언
		int[][] score = new int[stNum][5];
		//학생수만큼 각 학생의 국영수 점수를 입력받아 위의 배열에 저장
		for(int i=0; i<score.length; i++) {
			System.out.printf("[%d번째 학생의 점수 입력]\n", i+1);
			score[i][0] = i+1;
			System.out.print("국어점수 입력?");
			score[i][1] = scanner.nextInt();
			System.out.print("영어점수 입력?");
			score[i][2] = scanner.nextInt();
			System.out.print("수학점수 입력?");
			score[i][3] = scanner.nextInt();
		}
		//각 학생의 국영수 점수 및 총점 그리고 평균을 출력
		System.out.println("==========================");
		System.out.println("NO KOR ENG MAT TOT AVG");
		System.out.println("==========================");
		for(int i=0; i<score.length; i++) {
			//총점
			score[i][4] = score[i][1] + score[i][2] + score[i][3];
			//평균
			double avg = score[i][4] / 3.0;
			for(int j=0; j<score[i].length; j++) {
				System.out.print(score[i][j]+" ");
			}
			System.out.printf("\t%-2.2f", avg);
			System.out.println();
		}
		System.out.println("==========================");
	}
	
	
	//T
//	public static void main(String[] args)
//	{
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("학생수입력:");
//		int numberOfStudent = scanner.nextInt();
//		
//		//학생의 점수와 총점, 평균을 입력할 2차원배열 선언
//		int[][] jumsuArr = new int[numberOfStudent][5];
//		
//		//입력받은 학생수만큼 반복
//		for(int i=0; i<numberOfStudent; i++)
//		{
//			//국,영,수 점수를 입력받은 후
//			System.out.print("국어점수:");
//			int kor = scanner.nextInt();
//			System.out.print("영어점수:");
//			int eng = scanner.nextInt();
//			System.out.print("수학점수:");
//			int math = scanner.nextInt();
//			//배열에 입력한다.
//			jumsuArr[i][0] = kor;
//			jumsuArr[i][1] = eng;
//			jumsuArr[i][2] = math;
//		}
//		
//		//총점과 평균을 구한다.
//		for(int i=0; i<numberOfStudent; i++)	//학생수
//		{
//			//학생 한명의 총점
//			int sum = 0;
//			for(int j=0; j<3; j++)	//과목수
//			{
//				//i번째 학생의 국,영,수 점수의 총점을 구한다.
//				sum += jumsuArr[i][j];
//			}
//			jumsuArr[i][3] = sum;	//총점을 배열에 입력
//			jumsuArr[i][4] = sum / 3;	//평균을 배열에 입력
//		}
//		
//		//결과출력
//		System.out.printf("NO KOR ENG MAT TOT AVG\n");
//		for(int i=0; i<numberOfStudent; i++)	//학생수
//		{
//			System.out.print((i+1) +" ");	//학생의 순번
//			for(int j=0; j<5; j++)	//국,영,수,총점,평균까지 출력
//			{
//				System.out.printf("%4d ", jumsuArr[i][j]);
//			}
//			System.out.println();
//		}
//	}
}
