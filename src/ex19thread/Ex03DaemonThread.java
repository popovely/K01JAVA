package ex19thread;

/*
Thread로 구현하지 않은 클래스
 : 하나의 클래스가 작업을 끝내야 다음 클래스의 작업을 진행할 수가 있다.
   ;동시에 작업을 진행할 수 없다.
 */
class NotThread {
	String title;
	public NotThread(String title) {
		this.title = title;
	}
	void notThreadMethod() {
		for(int i=1; i<=10; i++) {
			System.out.println(String.format("%s]i=%d", title, i));
		}
	}
}

/*
독립쓰레드 (Non Daemon Thread)
 : 메인쓰레드(=main()메소드)와 working쓰레드(개발자가 정의한 쓰레드)를 일컫는다.
   메인쓰레드가 종료되어도 계속 실행되며,
   dead상태가 되어야 실행이 종료되는 쓰레드이다.
   해당 쓰레드는 main()메소드가 종료된 이후에도 독립적으로 계속 실행되기도 한다.
   
- main()메소드도 하나의 독립쓰레드이다.
 */
class YesThread extends Thread {
	/*
	쓰레드 생성시 이름을 지정하지 않으면 JVM이 자동으로 이름을 부여한다.
	 */
	public YesThread() {}
	/*
	Thread클래스의 생성자를 호출할 때 전달하는 매개변수를 통해
	super()로 전달해서 해당 쓰레드의 이름을 지정할 수 있다.
	지정된 이름은 getName()을 통해 반환할 수 있다.
	 */
	public YesThread(String threadName) {
		super(threadName);
	}
	
	void threadMethod() throws InterruptedException {
		for(int i=1; i<=10; i++) {
			//반복시의 횟수와 쓰레드의 이름을 출력
			System.out.println(String.format("%s]i=%d", getName(), i));
			//2초마다 블럭상태로 들어간다.
			sleep(2000);
		}
	}
	@Override
	public void run() {
		try {
			threadMethod();
		}
		catch (InterruptedException e) {}
	}
}
/*
종속쓰레드 (Daemon Thread)
 : 모든 독립쓰레드가 종료되면 자동으로 종료되는 쓰레드이다.
   메인메소드도 하나의 독립쓰레드이므로
   다른 독립쓰레드가 실행중이라면 종료될때까지는 프로그램이 종료된 것이 아니다.
   
   주로 프로그램의 보조역할을 하며
   배경음악, 로그 자동저장 등의 업무를 처리한다.
   프로그램이 종료될 때 자동으로 종료되므로 주로 무한루프로 구성한다.
   setDaemon(true)메소드로 설정한다.
 */
class DaemonThread extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println(String.format("[쓰레드명:%s]Jazz가 흘러요", getName()));
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장");
			}
			catch (InterruptedException e) {
				System.out.println("자동저장시 오류발생 ㅠㅠ");
			}
		}
	}
}

public class Ex03DaemonThread {

	public static void main(String[] args) {
		/*
		쓰레드로 구현하지 않은 일반적인 클래스의 작업
		 : 1번객체가 작업을 끝내야만 2번객체가 실행된다.
		   ;순차실행 된다.
		 */
		NotThread nt1 = new NotThread("첫번째 클래스");
		nt1.notThreadMethod();
		NotThread nt2 = new NotThread("두번째 클래스");
		nt2.notThreadMethod();
		
		/*
		독립쓰레드 (Non Daemon Thread) 실행
		 */
		//첫번째 독립쓰레드 생성
		YesThread yt1 = new YesThread("1st 쓰레드");	//이름부여 방법1
//		yt1.setName("첫번째쓰레드");					//이름부여 방법2
		yt1.start();
		
		//두번째 독립쓰레드 생성
		YesThread yt2 = new YesThread();	//이름을 지정하지 않아서 자동으로 부여됨
		yt2.setPriority(Thread.MAX_PRIORITY);	//우선순위는 10으로 지정됨
		yt2.start();
		
		/*
		데몬쓰레드(Daemon Thread) 실행
		 */
		DaemonThread dt = new DaemonThread();
		dt.setName("난 데몬쓰레드");
		dt.setDaemon(true);	/*
							독립쓰레드를 종속쓰레드로 만들어주는 문장
							;해당문장이 없으면 독립쓰레드가 된다.
							*/
		dt.start();
		
		//Thread클래스의 정적메소드를 통해 여러가지 정보확인
		System.out.println("현재활성화된상태의 쓰레드수"+ Thread.activeCount());
		System.out.println("현재 실행중인 쓰레드명:"+ Thread.currentThread().getName());
		System.out.println("메인함수의 우선순위:"+ Thread.currentThread().getPriority());
		System.out.println("메인함수(Main Thread) 종료");
	}
}
