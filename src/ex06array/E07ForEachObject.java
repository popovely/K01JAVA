package ex06array;

public class E07ForEachObject {

	public static void main(String[] args) {
		String[] strArr = new String[] {
				"자바는 재미있땅",
				"자바는 유용하당",
				"그러나 어렵당...ㅠ"
		};
		
		for(String e : strArr) {
			System.out.println(e);
		}
	}
}
