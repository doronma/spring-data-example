package starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.JdbcDaoImpl;
import dao.JdbcDaoImplOld;
import dao.JdbcDaoImplWithSupport;
import model.Circle;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		
		// old, no spring
		Circle circle = new JdbcDaoImplOld().getCircle(1) ;
		System.out.println(circle.getName());
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdbcDaoImpl = ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		
		//Circle circle2 = new Circle(2,"Second Circle");
		//jdbcDaoImpl.insertCircle(circle2);
		
		Circle circle3 = new Circle(3,"Third Circle");
		jdbcDaoImpl.insertCircleWithNamedTemplate(circle3);
		
		System.out.println(jdbcDaoImpl.getCircleCount());
		System.out.println(jdbcDaoImpl.getCirclename(1));
		System.out.println(jdbcDaoImpl.getCircleId(1));
		System.out.println(jdbcDaoImpl.getAllCircles());
		
		JdbcDaoImplWithSupport jdbcDaoImplWithSupport = ctx.getBean("jdbcDaoImplWithSupport",JdbcDaoImplWithSupport.class);
		System.out.println(jdbcDaoImplWithSupport.getCircleCount());
	}

}
