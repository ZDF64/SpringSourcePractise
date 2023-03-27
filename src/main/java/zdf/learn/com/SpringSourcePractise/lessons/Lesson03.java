package zdf.learn.com.SpringSourcePractise.lessons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zdf.learn.com.SpringSourcePractise.lessons.lesson03pck.AppConfig;
import zdf.learn.com.SpringSourcePractise.lessons.lesson03pck.OrderService;
import zdf.learn.com.SpringSourcePractise.lessons.lesson03pck.UserService;

/**
 * 
 * @Project       SpringSourcePractise
 * @CreatedTime   2023年3月7日
 * @Content       Spring如何创建Bean对象---->单例池---->@PostConstruct工作原理
 * @author        ZDF64
 *
 */
public class Lesson03 {
	
	public static void main(String[] args) {
		/**
		 * UserService类 ----> 无参构造方法 -----> 对象 -----> 依赖注入(DI) -----> 初始化前(执行特定方法) -----> 初始化 -----> 初始化后 ------> 放入Map单例池 -----> Bean对象
		 */
		AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService us = (UserService) application.getBean("userService");
		System.out.println(us);
		
		
		/********************大致方法********************/
		
		try {
			UserService user = new UserService();
			for(Field f: user.getClass().getDeclaredFields()) {
				if(f.isAnnotationPresent(Autowired.class)) {
					f.setAccessible(true);
					System.out.println("属性名:"+f.getName());
					System.out.println("属性类型:"+f.getGenericType().getTypeName());
					Class<?> clazz = Class.forName(f.getGenericType().getTypeName());
					f.set(user, clazz.newInstance());
				}
			}
			for(Method m : user.getClass().getDeclaredMethods()) {
				if(m.isAnnotationPresent(PostConstruct.class)) {
					m.setAccessible(true);
					m.invoke(user);
				}
			}
			user.test();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
}
