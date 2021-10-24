package quiz;

import java.util.Random;
import java.util.Scanner;

/*
[정렬알고리즘 - 선택정렬]
1. 1~100 사이의 중복되지 않는 정수 10개의 난수를 생성한다. 
2. 생성한 난수는 크기 10인 배열에 저장한다. 
3. 위 그림을 참조하여 선택정렬로 오름차순 정렬한다. 
4. 정렬한 결과를 출력한다. 
5. 단, 정렬되는 과정을 모두 출력해야 한다.

선택정렬은 전체요소 중에서 최소값을 찾아 첫번째 자리와 교환한다.
1회전을 수행하면 최소값이 맨 앞에 오게되므로 첫번째 자료를 제외한
나머지 자료에서 다시 최소값을 찾아 두번째 자리와 교환한다. 
이 과정을 반복한다. 
자료가 N개라면 교환은 (N-1)번 이루어진다.
 */
public class SelectionSort
{	
	static Random rnd = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		//1. 중복되지 않는 난수 10개 생성
		int[] arr = new int[10];
		//난수생성후 arr배열에 저장하기 위한 메소드 호출
		randomCreate(arr);
		
		//2. 생성한 난수를 통해 초기화된 배열을 출력 (정렬 전 출력)
		showArray(arr, "난수생성 직후 배열출력");
		
		//3. 선택정렬 알고리즘을 통한 정렬을 진행
		selectionSort(arr);
		
		//4. 정렬된 결과를 출력 (정렬 후 출력)
		showArray(arr, "선택정렬 이후 배열출력");
	}
	
	public static void selectionSort(int[] arrParam) {
		
		//swap(자리변경)을 위한 임시변수 생성
		int temp, index=0, swapCount=1;
		boolean check = false;
		
		while(true) {
			for(int i=0; i<arrParam.length-1; i++) {
				for(int j=i+1; j<arrParam.length; j++) {
					if(arrParam[index] > arrParam[j]) {
						temp = arrParam[index];
						arrParam[index] = arrParam[j];
						arrParam[j] = temp;
					}
					if(arrParam[index] > arrParam[j]) {
						index++;
					}
				}
				//값의 변경이 있을때마다 배열전체 출력
				showArray(arrParam,
						"SWAP중:"+ (swapCount++) +"회 교환");
			}
			if(check==false) break;
		}
	}
	
	public static void showArray(int[] arr, String msg) {
		System.out.println(msg);
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
	
	public static void randomCreate(int[] arrParam) {
		
		//난수생성을 위한 씨드설정
		rnd.setSeed(System.currentTimeMillis());
		
		while(true) {
			//1. 난수 10개 생성후 배열에 담기
			for(int i=0; i<arrParam.length; i++) {
				arrParam[i] = rnd.nextInt(100) + 1;
			}
			//2. 중복확인
			boolean olap = false;
			
			for(int i=0; i<arrParam.length; i++) {
				for(int j=0; j<arrParam.length; j++) {
					if(i!=j && arrParam[i]==arrParam[j]) {
						olap = true;
					}
				}
			}
			//3. 중복된 값이 없으면 break로 while루프 탈출
			if(olap==false) break;
		}
	}
}
