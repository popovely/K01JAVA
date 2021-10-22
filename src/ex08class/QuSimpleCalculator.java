package ex08class;

/*
문제1) 파일명 : QuSimpleCalculator.java (난이도:하)
기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 계산기 클래스를 정의해보자.
아래 main함수에 부합하는 CalculatorEx 클래스를 정의하면되고 해당 수치는 임의로 바꿔도 된다.
init() 멤버메소드에서는 계산의 결과를 카운트하는 멤버변수를 0으로 초기화 한다.

메인메소드 샘플코드]
public static void main(String[] args)
{
	CalculatorEx cal = new CalculatorEx();
	cal.init();
	System.out.println("1 + 2 = " + cal.add(1 , 2));
	System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
	System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
	System.out.println("100 / 25 = " + cal.div(100 , 25));
	System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
	cal.showOpCount();
}

실행결과]
1 + 2 = 3.0
10.5 - 5.5 = 5.0
4.0 * 5.0 = 20.0
100 / 25 = 4.0
10.0 * 3.0 = 30.0
덧셈횟수 : 1
뺄셈횟수 : 1
곱셈횟수 : 2
나눗셈횟수 : 1
 */

//기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 계산기 클래스
class CalculatorEx {
	//각각 실행횟수
	int numOfAdd;
	int numOfMin;
	int numOfMul;
	int numOfDiv;
	
	//계산의 결과를 카운트하는 멤버변수를 0으로 초기화 한다.
	public void init() {
		numOfAdd = 0;
		numOfMin = 0;
		numOfMul = 0;
		numOfDiv = 0;
	}
		
	//더하기
	public double add(double n1, double n2) {
		double addResult = n1 + n2;
		numOfAdd++;
		return addResult;
	}
	//빼기
	public double min(double n1, double n2) {
		double minResult = n1 - n2;
		numOfMin++;
		return minResult;
	}
	//곱하기
	public double mul(double n1, double n2) {
		double mulResult = n1 * n2;
		numOfMul++;
		return mulResult;
	}
	//나누기
	public double div(double n1, double n2) {
		double divResult = n1 / n2;
		numOfDiv++;
		return divResult;
	}
	
	//각 사칙연산의 수행횟수를 출력하는 메소드
	public void showOpCount() {
		System.out.println("덧셈횟수 : "+ numOfAdd);
		System.out.println("뺄셈횟수 : "+ numOfMin);
		System.out.println("곱셈횟수 : "+ numOfMul);
		System.out.println("나눗셈횟수 : "+ numOfDiv);
	}
}

public class QuSimpleCalculator {
	
	public static void main(String[] args)
	{
		CalculatorEx cal = new CalculatorEx();
		cal.init();
		System.out.println("1 + 2 = " + cal.add(1 , 2));
		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + cal.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
		cal.showOpCount();
	}
}
