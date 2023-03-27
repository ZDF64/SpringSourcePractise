package zdf.learn.com.SpringSourcePractise.lessons.lesson04pck;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements InitializingBean{
	@Autowired
	private OrderService order;
	
	private User admin;
	
	@PostConstruct
	public void initAdmin() {
		//mysql select ----> admin info ----> admin 
		System.out.println( "Read info from DB Post::: initAdmin" );
	}
	
	
	public void parseAdmin() {
		System.out.println("admin:::"+admin);
	}
	
	public void test() {
		System.out.println(order);
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println( "read info from DB Inprocess::: after Properties" );
	}
	
}
