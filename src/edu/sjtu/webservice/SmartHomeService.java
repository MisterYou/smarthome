package edu.sjtu.webservice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SmartHomeService {
		
	public String shSer(String str1,String str2){
		Connection conn = null;
		String sql,sql1;
		String res = null;
		String url = "jdbc:mysql://localhost/SmartHome?user=youjin&password=940707you&useUnicode=true&characterEncoding=UTF8";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("成功加载Mysql驱动");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			sql1 = "insert into smarthome(illumination,lamplight) values('"+str1+"'"+","+"'"+str2+"')";
			int rs1 = stmt.executeUpdate(sql1);
			res = "insert success";
			/*
			sql = "select * from smarthome";
			ResultSet rs = stmt.executeQuery(sql);
			//System.out.println("姓名\t年龄");
			String st;
			while(rs.next()){
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			}
			*/
		}catch(SQLException e){
			System.out.println("Mysql操作错误");
			
			e.printStackTrace();
			res = "insert error";
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
