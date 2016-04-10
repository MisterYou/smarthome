package edu.sjtu.webservice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTest {
	   private static void test(String str1,String str2){
		Connection conn = null;
		String sql,sql1;
		String url = "jdbc:mysql://localhost/SmartHome?user=youjin&password=940707you&useUnicode=true&characterEncoding=UTF8";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载Mysql驱动");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			sql1 = "insert into timetest(name,sex) values('"+str1+"'"+","+"'"+str2+"')";
			System.out.println(sql1);
			int rs1 = stmt.executeUpdate(sql1);
			
			sql = "select * from timetest";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("时间\t姓名\t年龄");
		    String st = null;
			
			while(rs.next()){
				//System.out.println(rs.getString(1) + "\t" +rs.getString(2) + "\t" + rs.getString(3));
				st = rs.getString(1)  +rs.getString(2)  + rs.getString(3);
				System.out.println(st);
				
			}
			
		}catch(SQLException e){
			System.out.println("Mysql操作错误");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
public static void main(String[] args) {
	test("you","M");
}

}
