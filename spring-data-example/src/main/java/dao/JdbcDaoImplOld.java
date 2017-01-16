package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Circle;

public class JdbcDaoImplOld {

	public JdbcDaoImplOld() {
		// TODO Auto-generated constructor stub
	}
	
	public Circle getCircle(int id){
		Connection conn = null;
		String driver = "org.apache.derby.jdbc.ClientDriver";
		Circle circle = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = conn.prepareStatement("Select * from circle where id = ?");
			ps.setInt(1, id); 
			ResultSet rs =  ps.executeQuery();
			if (rs.next()){
				circle = new Circle(id,rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return circle;
	}

}
