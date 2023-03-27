package zdf.learn.com.SpringSourcePractise.lessons.lesson02pck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	private OrderService order;
	public void test() {
		System.out.println(order);
	}
	
}
