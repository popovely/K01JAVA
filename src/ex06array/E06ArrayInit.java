package ex06array;

public class E06ArrayInit {

	public static void main(String[] args) {
		/*
		1차원, 2차원 배열은 크기만 지정된 경우에는
		전체요소가 0으로 초기화 된다.
		 */
		System.out.println("배열 선언후 초기화 하지않은 상태");
		int[] arr = new int[3];
		System.out.println("arr[0]="+ arr[0]);	//0출력
		
		int[][] arr2 = new int[3][4];
		System.out.println("arr2[0][0]="+ arr2[0][0]);	//0출력
		
		/*
		1차원 배열의 경우 요소의 개수에 의해 전체 크기가 결정된다.
		2차원 배열도 마찬가지이나 다른점은 가장 큰 요소의 개수에 의해
		크기가 결정되므로 빈 공간이 발생할 수 있다.
		이때 빈 공간은 null로 채워지고 배열의 크기에서 제외되는 부분이다.
		 */
		System.out.println("배열 선언과 동시에 초기화 한 상태");
		int[] arrDim = {1, 2, 3};
		System.out.println("arrDim[0]="+ arrDim[0]);
		
		int[][]	arr2Dim = {
				{1},
				{2, 3}
		};
		System.out.println("arr2Dim[0][0]="+ arr2Dim[0][0]);	//1
		System.out.println("arr2Dim[0][1]="+ arr2Dim[0][1]);	/*
												null값이므로 출력이 불가능해서
												예외가 발생한다.
												*/
	}
}
