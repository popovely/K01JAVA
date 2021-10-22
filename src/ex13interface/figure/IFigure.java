package ex13interface.figure;
/*
인터페이스 OR 클래스 하나당 하나의 자바파일을 구성하는것을 권장한다.
그렇게 해야 모든 클래스를 public으로 선언할 수 있기 때문에
접근이 용이해진다.
 */
public interface IFigure {
	//매개변수로 전달되는 도형의 넓이를 구하는 추상메소드
	void area(String figureName);
}
