package ex19thread;

class SumMulti2 {
	long num;
	public SumMulti2() {
		num=0;
	}
	
	/*
	synchronized 선언으로 인해 정확한 결과가 나오긴 하지만
	코드 실행시간이 훨씬 더 길어지는 단점이 있다.
	;동기화는 성능의 감소를 초래하므로 필요한 부분만 동기화 처리하는것이 좋다.
	- 동기화 블럭을 사용하는 것이 조금 더 좋은 성능을 유지할 수 있다.
	 */
	//방법1] 동기화메소드 : 메소드 전체를 동기화한다.
//	synchronized public void addNum(long n) {
//		num += n;
//	}
	//방법2] 동기화 블럭 : 필요한 코드만 동기화한다.
	public void addNum(long n) {
		synchronized(this) {
			num += n;
		}
	}
	
	
	public long getNum() {
		return num;
	}
}

class MultiAdderThread2 extends Thread {
	SumMulti2 sumInst;
	int start, end;
	public MultiAdderThread2(SumMulti2 sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	public void run() {
		for(int i=start; i<=end; i++) {
			sumInst.addNum(i);
		}
	}
}

public class Ex05Sync2Method {

	public static void main(String[] args) {
		SumMulti2 s = new SumMulti2();
		MultiAdderThread2 mat1 = new MultiAdderThread2(s, 1, 50000);
		MultiAdderThread2 mat2 = new MultiAdderThread2(s, 50001, 100000);
		mat1.start();
		mat2.start();
		
		try {
			mat1.join();
			mat2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~10000까지의 합:"+ s.getNum());
	}
}
