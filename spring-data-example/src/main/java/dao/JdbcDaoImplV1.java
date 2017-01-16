package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Circle;

@Component
public class JdbcDaoImplV1 {
	
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcDaoImplV1() {
		// TODO Auto-generated constructor stub
	}
	
	public Circle getCircle(int id){
		Connection conn = null;
		
		Circle circle = null;
		try {
			
			conn = dataSource.getConnection();
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
