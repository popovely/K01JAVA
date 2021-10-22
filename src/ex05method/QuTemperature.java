package ex05method;

import java.util.Scanner;

/*
문제5-3) 파일명 : QuTemperature.java  (난이도:중)
섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와
화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.

공식]
	화씨 = 1.8 * 섭씨 + 32
	섭씨 = (화씨 - 32) / 1.8
 */
public class QuTemperature {
	static double celToFah(double cel) {
		double fah = 1.8 * cel + 32;
		return fah;
	}
	
	static double fahToCel(double fah) {
		double cel = (fah - 32) / 1.8;
		return cel;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("섭씨온도(℃) : ");
		double celsius = scanner.nextDouble();
		double fahrenheit = celToFah(celsius);
		System.out.printf("섭씨 %.1f℃는 화씨 %.1f℉입니다.\n", celsius, fahrenheit);
		System.out.println("================================");
		
		System.out.print("화씨온도(℉) : ");
		fahrenheit = scanner.nextDouble();
		celsius = fahToCel(fahrenheit);
		System.out.printf("화씨 %.1f℉는 섭씨 %.1f℃입니다.", fahrenheit, celsius);
	}
}
