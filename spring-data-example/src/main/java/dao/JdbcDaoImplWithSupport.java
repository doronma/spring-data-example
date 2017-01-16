package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoImplWithSupport extends JdbcDaoSupport {
	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		Integer count = getJdbcTemplate().queryForObject(sql, Integer.class);
		return count ;
	}
}
