package quiz;

import java.util.Random;

/*
[정렬알고리즘 - 버블정렬]
1. 중복되지 않는 난수 10개(1~99)를 생성하여 크기가 10인 배열에 담는다.
2. 오름차순으로 버블정렬한다.(1, 2, 3 …… 10)
3. 버블정렬이란 모든 배열요소를 순차적으로 비교하여 스왑(교환)하는 알고리즘이다.
4. 단, 정렬되는 과정을 모두 출력해야 한다.
5. 위 그림은 버블정렬을 이용하여 오름차순으로 정렬하는 과정이다.

 */
//public class BubbleSort {
//
//	public static void main(String[] args) {
//		Random random = new Random();
//		
//		int[] bubble = new int[10];
//		
//		//1. 중복되지 않는 10개의 난수 생성
//		while(true) {
//			boolean reTry = false;
//			for(int i=0; i<bubble.length; i++) {
//				bubble[i] = random.nextInt(99) +1;
//			}
//			for(int i=0; i<bubble.length; i++) {
//				int j = i + 1;
//				if(j==bubble.length) j = 0;
//				if(bubble[i]==bubble[j]) {
//					reTry = true;
//				}
//			}
//			if(reTry==false) break;
//		}
//		System.out.println("[1~99사이의 중복되지 않는 난수 10개 생성]");
//		for(int i=0; i<bubble.length; i++) {
//			System.out.print(bubble[i] +" ");
//		}
//		System.out.println();
//		
//		//2. 오름차순으로 버블정렬
//		System.out.println("\n[버블정렬 과정]");
//		for(int i=0; i<bubble.length-1; i++) {
//			for(int j=i+1; j<bubble.length; j++) {
//				if(bubble[i]>bubble[j]) {
//					int swap = 0;
//					swap = bubble[i];
//					bubble[i] = bubble[j];
//					bubble[j] = swap;
//				}
//				for(int p=0; p<bubble.length; p++) {
//					System.out.print(bubble[p] +" ");
//				}
//				System.out.println();
//			}
//		}
//		
//		//3. 결과
//		System.out.println("\n[버블정렬 결과]");
//		for(int i=0; i<bubble.length; i++) {
//			System.out.print(bubble[i] +" ");
//		}
//	}
//}

//T
public class BubbleSort
{
	public static void main(String[] args) {
		//중복되지 않는 난수를 생성
		Random random = new Random();
		int[] arr = new int[10];
		
		while(true) {
			//난수10개 생성
			for(int i=0; i<arr.length; i++) {
				arr[i] = random.nextInt(99)+1;
			}
			//중복체크를 위한 변수
			boolean rndFlag = false;
			//중복확인
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i]==arr[j] && i!=j) {
						rndFlag = true;	//중복된 값이 발견되면 true로 변경
					}
				}
			}
			//중복된 값이 없다면 break로 while루프 탈출
			if(rndFlag==false) break;
			System.out.println("난수생성시도");
		}
		//생성된 난수를 출력
		//난수확인
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//버블정렬
//		for(int i=0; i<arr.10-1; i++) {
		int temp;
		/*
		크기가 10인 배열이므로 스캔은 9번만 반복하면 된다.
		;i의 증가치는 0~8까지 변한다. 
		 */
		for(int i=0; i<arr.length-1; i++) {
			/*
			 - 실제 요소값에 대한 비교를 진행하여 큰 숫자를 뒤로 보내준다.
			   ;요소1과 2를 비교하여 요소1이 크면 두 요소를 교환(swap)한다.
			 - 한번 스캔을 완료하면 가장 큰 숫자가 제일 뒤로 밀리게 되므로
			   비교의 구간을 하나 줄여주기 위해 i를 차감한다.
			*/
			for(int j=0; j<(arr.length-1)-i; j++) {
				//앞의 숫자가 더 크다면 뒤의 숫자와 교환한다.
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			for(int k=0; k<arr.length; k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
		}
		//정렬된 난수를 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
