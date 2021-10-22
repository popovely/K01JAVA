package ex19thread;

class Sum {
	int num;
	public Sum() {
		num=0;
	}
	//메소드 호출시 전달되는 매개변수의 값을 누적해서 더한다.
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}
/*
Thread클래스를 생성하는 두번째방법
 : Java는 다중상속이 지원되지 않으므로, 다른 클래스를 상속받아야 한다면
   Runnable 인터페이스를 구현해서 쓰레드 클래스를 정의해야 한다.
 */
class AdderThread extends Sum implements Runnable {
	int start, end;
	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}
	/*
	멤버변수 start부터 end까지 반복하면서
	부모클래스의 addNum()를 호출하여 누적합을 구한다.
	start가 1이고 end가 10이라면 1~10까지의 합을 구하게 된다.
	 */
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			//쓰레드의 동작확인을 위한 로그
			System.out.println("i="+ i);
			addNum(i);
		}
	}
}

public class Ex04Runnable {

	public static void main(String[] args) {
		
		/*
		Runnable 인터페이스를 구현한 클래스의 객체를 대상으로 쓰레드를 생성한다.
		해당 방법도 결국은 Thread클래스를 통해서 쓰레드를 생성하게 된다.
		 */
		AdderThread at1 = new AdderThread(1, 500);
		AdderThread at2 = new AdderThread(501, 1000);
		
		Thread thread1 = new Thread(at1);
		Thread thread2 = new Thread(at2);
		
		//2개의 쓰레드 생성
		thread1.start();
		thread2.start();
		
		try {
			/*
			join()
			 : 생성된 쓰레드가 작업을 완료하기를 기다리는 기능을 수행한다.
			   ;해당 쓰레드에서 하나의 작업이 종료되기를 기다렸다가
			   다음 쓰레드를 실행한다.
			   쓰레드에 동시접근을 제한하는 기능이다.
			 */
			thread1.join();
			thread2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~1000까지의 합:"+ (at1.getNum()+at2.getNum()));
	}
}
