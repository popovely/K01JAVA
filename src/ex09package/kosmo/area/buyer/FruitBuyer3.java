package ex09package.kosmo.area.buyer;

import ex09package.kosmo.area.seller.FruitSeller3;

//구매자를 추상화한 클래스
public class FruitBuyer3 {
	FruitSeller3 seller = new FruitSeller3(0, 0, 0);
	int myMoney;	//구매자가 보유한 금액
	int numOfApple;	//구매자가 구매한 사과의 개수
	
	//초기화 메소드 선언
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	//구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}