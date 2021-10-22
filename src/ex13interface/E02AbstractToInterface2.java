package ex13interface;

/*
추상클래스를 인터페이스로 변경하기
	abstract class	=> interface
	메소드는 public abstract 제거
	멤버변수는 public static final로 변경
 */
interface IPersonalNumberStorage {
	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}

/*
DTO에서 VO로 이름만 변경함
 */
class PersonalInfoVO {
	private String name;
	private String juminNum;
	
	public PersonalInfoVO(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJuminNum() {
		return juminNum;
	}
	public void setJuminNum(String juminNum) {
		this.juminNum = juminNum;
	}
}

/*
클래스가 클래스를 상속받을때 	=> extends
클래스가 인터페이스를 상속받을때 	=> implements
드물지만 인터페이스가 인터페이스를 상속받을때 	=> extends

extends는 '상속', implements는 '구현'이라 표현한다.
 */
class PersonalNumberStorageImpl implements IPersonalNumberStorage {
	PersonalInfoDTO[] personalArr;	//정보저장용 객체배열
	int numOfPerInfo;	//입력정보 카운트용 변수
	
	//생성자
	public PersonalNumberStorageImpl(int arrSize) {
		personalArr = new PersonalInfoDTO[arrSize];
		numOfPerInfo = 0;
	}
	
	/*
	상속을 통해 추상메소드를 포함하게 되었으므로
	반드시 아래와 같이 오버라이딩 해야한다.
	필수사항이며 하지 않을경우 에러가 발생한다.
	 */
	
	//전달받은 인자를 통해 DTO객체를 생성한 후 객체배열을 추가한다.
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] = new PersonalInfoDTO(name, juminNum);
		numOfPerInfo++;
	}
	
	//주민번호를 인자로 객체배열을 검색한 후 정보를 반환한다.
	@Override
	public String searchPersonalInfo(String juminNum) {
		for(int i=0; i<numOfPerInfo; i++) {
			/*
			멤버변수를 private으로 선언했으므로 외부에서는 접근할 수 없다.
			이럴때 getter메소드를 통해 접근해서 값을 얻어올 수 있다.
			 */
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0) {
				return personalArr[i].getName();
			}
		}
		return null;
	}
}

public class E02AbstractToInterface2 {

	public static void main(String[] args) {
		//10명의 정보를 저장할 수 있는 객체배열 생성
		PersonalNumberStorageImpl storage = new PersonalNumberStorageImpl(10);
		
		//정보 추가
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//정보 검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("901234-3333333"));
	}
}
