package zdf.learn.com.SpringSourcePractise.lessons.lesson03pck;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	private OrderService order;
	
	private User admin;
	
	@PostConstruct
	public void initAdmin() {
		//mysql select ----> admin info ----> admin 
		System.out.println( "read info from DB:::" );
	}
	
	
	public void parseAdmin() {
		
	}
	
	public void test() {
		System.out.println(order);
	}
	
}
