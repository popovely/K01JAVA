package ex21jdbc.statement;

import java.sql.SQLException;

//추상클래스를 상속하여 정의
public class UpdateQuery extends ConnectDB {
	
	public UpdateQuery(String user, String pass) {
		//인자를 가진 부모의 생성자를 호출
		super(user, pass);
	}
	
	@Override
	void execute() {
		try {
			//statement객체 생성 및 쿼리작성 후 실행
			stmt = con.createStatement();
			
			String sql = "UPDATE member "
					+ " SET "
					+ " 	pass='1111' , "
					+ " 	name='이순신', "
					+ " 	regidate=sysdate "
					+ " WHERE id='test1' ";
			System.out.println("sql="+ sql);
			/*
			쿼리실행시 사용하는 메소드 종류
				1. executeUpdate()		→ int값 반환
				 : 쿼리문이 insert/update/delete와 같이
				   기존레코드에 영향을 미치는 경우 사용한다.
				   실행후 영향을 받은 행의 개수를 int형으로 반환한다.
				   
				2. executeQuery()		→ ResultSet객체 반환
				 : select 쿼리를 실행할 때 호출하는 메소드.
				   레코드에 영향을 미치지 않고 조회만 하는 경우에 사용한다.
				   조회한 레코드를 반환값으로 받아야하므로
				   ResultSet객체를 반환타입으로 사용한다.
			 */
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected +"행이 업데이트 됨");
		}
		catch (SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new UpdateQuery("kosmo", "1234").execute();
	}
}
