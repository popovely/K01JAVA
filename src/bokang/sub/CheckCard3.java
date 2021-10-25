package bokang.sub;


/*
체크카드 클래스 Ver.03
	: initMembers 초기화 메소드는 삭제처리 
	
	1.충전은 10000원 단위로만 가능하다.
	만약 5000원을 충전하면 충전불능으로 처리한다.
	
	2.잔고가 부족하면 결제불능으로 처리해야 한다.
	
	3.생성자 오버로딩 처리
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	
	4.포인트 적립율 변경
		10만원 이하결제 : 0.1%적립
		10만원 초과결제 : 0.3%적립
 */
public class CheckCard3
{
	private long cardNumber;//카드번호
	private String owner;//소유자
	private int balance;//잔액
	private int point;//포인트
	
	//기본생성자(디폴트생성자)
	public CheckCard3() {}
	//new CheckCard3(카드번호, 소유자, 잔고, 포인트);
	public CheckCard3(long cardNumber, String owner, int balance, int point)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	//new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
	public CheckCard3(long cardNumber, String owner, int balance)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = 0;
	}
	//new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	public CheckCard3(long cardNumber, String owner)
	{
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = 0;
		this.point = 0;
	}
	
	public long getCardNumber()
	{
		return cardNumber;
	}

	
	public void setCardNumber(long cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int balance)
	{
		this.balance = balance;
	}

	public int getPoint()
	{
		return point;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}

	//멤버메소드
	//충전(입금) : 충전은 10000원 단위로만 가능하다.
	public void charge(int amount) {
		if(amount%10000==1) {
			//현재 잔고에 충전할 금액 amount를 더한다.
			this.balance += amount;
		}
		else {
			System.out.println("충전불가.");
			System.out.println("충전은 만원 단위로만 가능합니다.");
		}
	}
	
	//결제 : 잔고가 부족하면 결제불능으로 처리해야 한다.
	public void payment(int amount) {
		if(this.balance>=amount) {
			//잔고에서 사용한 금액을 차감한다.
			this.balance -= amount;
		}
		else {
			System.out.println("잔고부족. 출금이 불가합니다.");
		}
		//체크카드 사용시 적립금이 발생하므로 해당 메소드를 호출한다.
		savingPoint(amount);
	}
	
	//적립 : 10만원 이하결제 : 0.1%적립 / 10만원 초과결제 : 0.3%적립
	public void savingPoint(int amount) {
		
		if(amount<=100000) {
			double plusPoint = amount * 0.1;
		}
		else {
			double plusPoint = amount * 0.3;
		}
		this.point += getPoint();
	}
	
	//현재상태출력
	public void showState() {
		System.out.println("카드번호:"+ this.cardNumber);
		System.out.println("소유자:"+ this.owner);
		System.out.println("잔고:"+ this.balance);
		System.out.println("포인트:"+ this.point);
	}
}
