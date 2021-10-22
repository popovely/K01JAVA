package ex19thread;
/*
Thread의 우선순위
 - setPriority(우선순위) : Thread의 우선순위를 지정할 때 사용
 - getPriority() : Thread의 우선순위를 반환할 때 사용
 */
class MessageSendingThread extends Thread {
	String message;
	
	//생성자1 : 이름만 지정
	public MessageSendingThread(String str) {
		message = str;
	}
	//생성자2 : 이름, 우선순위 지정
	public MessageSendingThread(String str, int pri) {
		message = str;
		setPriority(pri);
	}
	
	public void run() {
		for(int i=1; i<=1000; i++) {
			//각 Thread당 1000개씩 반복출력. 이때 우선순위를 함께 출력한다.
			System.out.println(message + i +"("+ getPriority() +")");
			
			/*
			기본적으로 우선순위가 높은 Thread가 먼저 실행되지만
			sleep()메소드를 사용하면 실행중 잠깐씩 블럭상태로 전환되어
			우선순위가 낮은 Thread도 가끔씩 실행될 수 있는 상황이 생긴다.
			 */
			try {
				//0.001초동안 블럭상태로 전환한다.
				sleep(1);
			}
			catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex02Priority {

	public static void main(String[] args) {
		
		/*
		1단계실행
		 : 우선순위를 부여하지 않은 상태.
		   Thread를 생성하면 동일한 우선순위인 5를 각각 부여받는다.
		   이때는 CPU가 알아서 작업을 분배한다.
		 */
//		MessageSendingThread tr1 = new MessageSendingThread("첫번째");
//		MessageSendingThread tr2 = new MessageSendingThread("두번째");
//		MessageSendingThread tr3 = new MessageSendingThread("세번째");
		
		/*
		2단계실행
		 : 우선순위 부여를 위해 정수를 사용한다.
		   우선순위는 1~10사이에서 부여할 수 있고 높을수록 우선순위도 높아진다.
		   ※단, 우선순위가 높다고 무조건 먼저 실행되지는 않는다.
		   전체적인 확률이 높아져서 먼저 실행될 가능성이 높아진다고 생각하면 된다.
		 */
//		MessageSendingThread tr1 = new MessageSendingThread("첫번째", 1);
//		MessageSendingThread tr2 = new MessageSendingThread("두번째", 10);
//		MessageSendingThread tr3 = new MessageSendingThread("세번째", 5);
		
		/*
		3단계실행
		 : 정수대신 static(정적) 상수를 사용하여 우선순위를 부여할 수 있다.
		   결과는 2단계와 동일하다.
		 */
		MessageSendingThread tr1 = new MessageSendingThread("첫번째", Thread.MAX_PRIORITY);
		MessageSendingThread tr2 = new MessageSendingThread("두번째", Thread.NORM_PRIORITY);
		MessageSendingThread tr3 = new MessageSendingThread("세번째", Thread.MIN_PRIORITY);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}
}
