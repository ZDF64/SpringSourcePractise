package zdf.learn.com.SpringSourcePractise.lessons;

import java.applet.AppletContext;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zdf.learn.com.SpringSourcePractise.lessons.lesson01pck.AppConfig;
import zdf.learn.com.SpringSourcePractise.lessons.lesson01pck.OrderService;
import zdf.learn.com.SpringSourcePractise.lessons.lesson01pck.UserService;

/**
 * 
 * @Project       SpringSourcePractise
 * @CreatedTime   2023��3��7��
 * @Content       Spring��δ���Bean����
 * @author        ZDF64
 *
 */
public class Lesson01 {
	
	public static void main(String[] args) {
		/**
		 * UserService�� ----> �޲ι��췽�� -----> ���� -----> ����ע��(DI) -----> Bean����
		 */
		AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService us = (UserService) application.getBean("userService");
		us.test();
		/********************���·���********************/
		
		try {
			UserService us1 = new UserService();
			for(Field f : us1.getClass().getDeclaredFields()) {
				if(f.isAnnotationPresent(Autowired.class)) {
					f.setAccessible(true);
					f.set(us1, new OrderService());
				}
			}
			us1.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
