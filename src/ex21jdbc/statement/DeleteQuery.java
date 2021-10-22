package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
같은 내용이 계속해서 반복된당..
불편함을 느껴봐라!
그리고 정신차렸으면 상속을 해랑
 */
public class DeleteQuery
{
	//멤버변수
	private Connection con;
	private Statement stmt;
	
	//생성자 - 드라이버 로드만 진행
	public DeleteQuery() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			//ojdbc6.jar 파일이 없거나 연동되지 않았을 때 발생하는 예외
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	public void connect() {
		try {
			//오라클 DB에 연결	→ 정상적으로 연결되면 connection객체를 반환
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"kosmo",
					"1234");
			System.out.println("오라클 DB 연결성공");
		}
		catch (SQLException e) {
			//커넥션URL이나 접속정보(아이디/패스워드)가 잘못되었을 때 발생하는 예외
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
	//오라클 연결, 쿼리작성, 전송, 실행
	private void execute() {
		connect();
		try {
			/*
			'test99'와 같이 실제 존재하지 않는 레코드에 대한 삭제를 진행하면
			에러가 발생하지 않고, 삭제되는 데이터가 없으므로
			"0행이 삭제됨"이라는 결과만 나온다.
			 */
			stmt = con.createStatement();
			String query = "DELETE FROM member WHERE id='test2'";
			int affected = stmt.executeUpdate(query);
			
			System.out.println(affected +"행이 삭제됨");
		}
		catch (SQLException e) {
			System.out.println("쿼리실행 오류발생");
			e.printStackTrace();
		}
		finally {
			/*
			try문으로 진입했다면 예외가 발생하더라도 무조건 실행되는 구문.
			자원해제를 위한 close()메소드를 호출한다.
			 */
			close();
		}
	}
	
	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원반납완료");
		}
		catch (SQLException e) {
			System.out.println("자원반납시 오류가  발생하였습니다.");
		}
	}//end of close
	
	public static void main(String[] args) {
		//객체생성과 메소드 호출을 한번에 진행
		new DeleteQuery().execute();
	}
}
