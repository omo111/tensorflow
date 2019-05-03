



import java.util.*;
import java.sql.*;
public class Aaa extends Aadb {

	Scanner scanner =new Scanner(System.in);
	
	

public Aaa() {
	System.out.println("## 이벤트 등록을 위해 이름과 이메일을 입력하세요");
	System.out.println("이름 :");
	String uname = scanner.next();
	System.out.println("이메일 :");
	String email = scanner.next();
	
	connectDB();
	registUser(uname , email);
	printList();
	closeDB();
}



private void registUser(String uname, String email) {
	String sql = "insert into event_1 values(?,?)";
	try {
		//3단계 : Statement 생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1 , uname);
		pstmt.setString(2 , email);
		
		// 4단계  SQL문 전송
		pstmt.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

private void printList() {
	System.out.println("# 등록자명단");
	String sql = "select * from event_1";
	try {
		pstmt = conn.prepareStatement(sql);
		
		//5단계 결과 받기
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println( rs.getString("uname") + "," + rs.getString(2) );
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aaa a = new Aaa();
	}

}
