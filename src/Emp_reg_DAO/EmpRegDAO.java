package Emp_reg_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpRegDAO {
	public int save(int id,String name,String email,String address) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=conn.prepareStatement("insert into azenemp values (?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, address);
		int i=ps.executeUpdate();
		return i;
	}
	public boolean update(int id,String name,String email,String address) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=conn.prepareStatement("update azenemp set name=?,email=?,address=? where id=?");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, address);
		ps.setInt(4, id);
		int i=ps.executeUpdate();
		if(i!=0)
			return true;
		else 
		   return false;
		
		}
	public int delete(int id) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=conn.prepareStatement("delete from azenemp where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		return i;
}
	
}	
