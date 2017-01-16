package starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.JdbcDaoImpl;
import model.Circle;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdbcDaoImpl = ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		//Circle circle = jdbcDaoImpl.getCircle(1) ;
		//System.out.println(circle.getName());
		System.out.println(jdbcDaoImpl.getCircleCount());
		System.out.println(jdbcDaoImpl.getCirclename(1));
		System.out.println(jdbcDaoImpl.getCircleId(1));
		System.out.println(jdbcDaoImpl.getAllCircles());
	}

}
