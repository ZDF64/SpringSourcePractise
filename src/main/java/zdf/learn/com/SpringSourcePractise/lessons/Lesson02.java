package zdf.learn.com.SpringSourcePractise.lessons;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zdf.learn.com.SpringSourcePractise.lessons.lesson02pck.AppConfig;
import zdf.learn.com.SpringSourcePractise.lessons.lesson02pck.UserService;

/**
 * 
 * @Project       SpringSourcePractise
 * @CreatedTime   2023年3月7日
 * @Content       Spring如何创建Bean对象---->单例池
 * @author        ZDF64
 *
 */
public class Lesson02 {
	
	public static void main(String[] args) {
		/**
		 * UserService类 ----> 无参构造方法 -----> 对象 -----> 依赖注入(DI) ------> 放入Map单例池 -----> Bean对象
		 */
		AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService us = (UserService) application.getBean("userService");
		UserService us1 = (UserService) application.getBean("userService");
		UserService us2 = (UserService) application.getBean("userService");
		System.out.println(us);
		System.out.println(us1);
		System.out.println(us2);
	}
}
