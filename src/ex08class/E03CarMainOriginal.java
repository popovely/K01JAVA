package ex08class;

class CarOriginal {
	
	//멤버상수
	public static final String AUTO = "자동";
	public static final String MANUAL = "수동";
	/*
	상수(혹은 변수)를 static으로 선언하면 객체생성없이
	즉시 접근할 수 있다.
	 */
	
	//멤버변수
	String carGear = AUTO;	//미션
	String carModel;	//모델명
	int carYear;	//연식
	Human owner;	//소유주(Human타입의 멤버변수)
		/*
			Human클래스를 기반으로 하는 멤버변수로 초기화를 위해
			이름, 나이, 에너지 세가지의 값이 필요하다.
			이와같이 클래스를 구성할때 또 다른 객체를 멤버변수로
			선언할 수 있다.
		 */
	
	//멤버메소드
	void drive() {
		/*
		owner는 객체이므로 이름을 출력하기 위해서는
		'멤버변수.name'으로 기술해야 한다.
		 */
		System.out.println(owner.name +"이(가) "+ carModel +"을 운전한다.");
	}
	
	/*
	객체의 초기화를 담당하는 메소드로 아래는 항상 같은 값으로만
	초기화된다는 한계를 가지고있다.
	따라서 이와같은 형태로는 만들지 않는것이 좋다.
	 */
	void initialize() {
		carModel = "람보르기니";
		carYear = 2017;
		owner = new Human();
		owner.name = "캡틴로져스";
		owner.age = 30;
		owner.energy = 10;
	}
	/*
	위와 동일한 이름의 메소드로 오버로딩에 의해 정의된 초기화 메소드이다.
	초기화를 진행하는 역할은 동일하지만, 매개변수를 통해 다양한 형태의
	객체를 초기화 할수 있다.
	 */
	void  initialize(String model, int year, String name, int age, int energy) {
		carModel = model;
		carYear = year;
		/*
		클래스의 멤버변수로 또다른 객체를 포함한 형태이므로
		new를 통해 객체를 생성한 후 초기화해야 한다.
		 */
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}
	//객체의 현재상태를 출력하는 멤버메소드
	
	void showCarInfo() {
		System.out.println("[차량정보]");
		System.out.printf("모델명:%s\n", carModel);
		System.out.printf("연식:%d\n", carYear);
		System.out.printf("기어:%s\n", carGear);
		owner.showState();
	}
}////end of Car Class

public class E03CarMainOriginal {
	public static void main(String[] args) {
		//자동차1 객체 생성
		CarOriginal car1 = new CarOriginal();
		System.out.println("[초기화메소드 호출전]");
		System.out.println("car1.owner="+ car1.owner);
//		car1.drive();	->실행시 예외 발생
		/*
			자동차 소유주를 표현하는 Human객체가
			초기화되지 않은 상태에서 출력을 시도하여 예외가 발생된다.
		 */
		
		System.out.println("[초기화메소드 호출후]");
		//초기화 메소드를 호출한 후 멤버메소드 호출함
		car1.initialize();
		car1.drive();
		car1.showCarInfo();
		
		/*
		자동차2 객체 생성
			: 객체 생성 후 멤버변수에 직접 접근하여 초기화한다.
		 */
		CarOriginal car2 = new CarOriginal();
		car2.carGear = CarOriginal.MANUAL;	//static으로 선언하면 클래스명으로 멤버변수에 바로 접근가능
		car2.carModel = "밴틀리";
		car2.carYear = 2018;
		
		car2.owner = new Human();
		car2.owner.name = "토니스타크";
		car2.owner.age = 52;
		car2.owner.energy = 8;
		
		System.out.println("자동차정보와 소유자정보 같이보기");
		car2.showCarInfo();
		
		/*
		자동차3 객체 생성
			: 매개변수가 있는 초기화 메소드를 이용하여 초기화를 진행한다.
		 */
		CarOriginal car3 = new CarOriginal();
		car3.initialize("포르쉐", 2021, "포포", 4, 10);
		car3.showCarInfo();
	}
}
