



import java.util.*;
import java.sql.*;
public class Aaa extends Aadb {

	Scanner scanner =new Scanner(System.in);
	
	

public Aaa() {
	System.out.println("## �̺�Ʈ ����� ���� �̸��� �̸����� �Է��ϼ���");
	System.out.println("�̸� :");
	String uname = scanner.next();
	System.out.println("�̸��� :");
	String email = scanner.next();
	
	connectDB();
	registUser(uname , email);
	printList();
	closeDB();
}



private void registUser(String uname, String email) {
	String sql = "insert into event_1 values(?,?)";
	try {
		//3�ܰ� : Statement ����
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1 , uname);
		pstmt.setString(2 , email);
		
		// 4�ܰ�  SQL�� ����
		pstmt.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

private void printList() {
	System.out.println("# ����ڸ��");
	String sql = "select * from event_1";
	try {
		pstmt = conn.prepareStatement(sql);
		
		//5�ܰ� ��� �ޱ�
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
