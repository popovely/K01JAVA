package quiz;

import java.util.Random;

/*
1. 중복되지 않는 난수 10개(1~99)를 생성하여 크기가 10인 배열에 담는다.
2. 오름차순으로 버블정렬한다.(1, 2, 3 …… 10)
3. 버블정렬이란 모든 배열요소를 순차적으로 비교하여 스왑(교환)하는 알고리즘이다.
4. 단, 정렬되는 과정을 모두 출력해야 한다.
5. 위 그림은 버블정렬을 이용하여 오름차순으로 정렬하는 과정이다.

 */
public class BubbleSort {

	public static void main(String[] args) {
		Random random = new Random();
		
		int[] bubble = new int[10];
		
		//1. 중복되지 않는 10개의 난수 생성
		while(true) {
			boolean reTry = true;
			for(int i=0; i<bubble.length; i++) {
				bubble[i] = random.nextInt(99) +1;
			}
			for(int i=0; i<bubble.length; i++) {
				int j = i + 1;
				if(j==bubble.length) j = 0;
				if(bubble[i]==bubble[j]) {
					reTry = false;
				}
			}
			if(reTry==true) break;
		}
		System.out.println("[1~99사이의 중복되지 않는 난수 10개 생성]");
		for(int i=0; i<bubble.length; i++) {
			System.out.print(bubble[i] +" ");
		}
		System.out.println();
		
		//2. 오름차순으로 버블정렬
		System.out.println("\n[버블정렬 과정]");
		for(int i=0; i<bubble.length-1; i++) {
			for(int j=i+1; j<bubble.length; j++) {
				if(bubble[i]>bubble[j]) {
					int swap = 0;
					swap = bubble[i];
					bubble[i] = bubble[j];
					bubble[j] = swap;
				}
				for(int p=0; p<bubble.length; p++) {
					System.out.print(bubble[p] +" ");
				}
				System.out.println();
			}
		}
		
		//3. 결과
		System.out.println("\n[버블정렬 결과]");
		for(int i=0; i<bubble.length; i++) {
			System.out.print(bubble[i] +" ");
		}
	}
}
