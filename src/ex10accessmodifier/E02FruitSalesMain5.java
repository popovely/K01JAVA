package ex10accessmodifier;

//과일판매자를 추상화한 클래스
class FruitSeller3 {
	public int numOfApple;	//판매자가 보유한 사과개수
	public int myMoney;	//판매수익
	public final int APPLE_PRICE;	//사과의 단가
	
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}

//구매자를 추상화한 클래스
class FruitBuyer3 {
	public int myMoney;	//구매자가 보유한 금액
	public int numOfApple;	//구매자가 구매한 사과의 개수
	
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

//프로그램의 출발점이 되는 메인 클래스
public class E02FruitSalesMain5
{
	public static void main(String[] args)
	{
		//판매자1 : 사과 100개, 단가 1000원
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		
		//판매자2 : 사과 80개, 단가 500원
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		
		//구매자 : 보유금액 10000원
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		/////////////////////////////////////////////////////////////
		/*
		아래의 코드는 문법적으로 오류가 없으나 지불금액과 구매한 사과의
		관계가 전혀 맞지 않는 논리적 오류가 발생되었다.
		즉, 코드(메소드)로 구현한 규칙이 완전히 무너지게 된다.
		객체지향 프로그래밍에서는 이런 오류를 막기위해 멤버변수에 대한
		"정보은닉"을 하도록 규정하고 있다.
		 */
		seller1.myMoney += 1000;	//판매자1에게 1000원을 지불하고
		seller1.numOfApple -= 50;	//사과 50개를 구매한다.
		buyer.numOfApple += 50;		//구매자는 50개가 증가하였다.
		
		seller2.myMoney += 1000;	//판매자2에게 1000원을 지불하고
		seller2.numOfApple -= 70;	//사과 70개를 구매했다.
		buyer.numOfApple += 70;		//따라서 구매자가 가진 사과는 70개가 증가했다.
									//하지만 구매자의 금액은 차감되지 않는다.
		
		System.out.println("구매행위가 일어난 후의 상태2");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}
}
