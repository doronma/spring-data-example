package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import model.Circle;

@Component
public class JdbcDaoImpl {
	
	
	
	private JdbcTemplate jdbcTemplate;

	public JdbcDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count ;
	}
	
	public String getCirclename(int id){
		String sql = "Select NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object [] {id}, String.class);
	}
	
	public Circle getCircleId(int id){
		
		String sql = "Select * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new CircleMapper(), new Object [] {id});
		
		
	}
	
	public List<Circle> getAllCircles(){
		String sql = "Select * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle){
		String sql = "INSERT INTO CIRCLE (ID,NAME) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
		
	}
	
	public void createTriangleTable(){
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER,NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
		
	private static final class CircleMapper implements RowMapper<Circle>{

		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("id"));
			circle.setName(resultSet.getString("name"));
			return circle;
		}
		
	}

}
