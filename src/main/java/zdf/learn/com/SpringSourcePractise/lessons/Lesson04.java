package zdf.learn.com.SpringSourcePractise.lessons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zdf.learn.com.SpringSourcePractise.lessons.lesson04pck.AppConfig;
import zdf.learn.com.SpringSourcePractise.lessons.lesson04pck.UserService;

/**
 * 
 * @Project       SpringSourcePractise
 * @CreatedTime   2023年3月7日
 * @Content       Spring如何创建Bean对象---->单例池---->@PostConstruct工作原理----->InitializingBean接口实现afterPropertiesSet方法
 * ------>Bean实例化,Bean初始化
 * @author        ZDF64
 *
 */
public class Lesson04 {
	
	public static void main(String[] args) {
		/**
		 * UserService类 ----> 无参构造方法 -----> 对象 -----> 依赖注入(DI) -----> 
		 * 初始化前(执行特定方法) -----> 初始化 -----> 初始化后(AOP) ------> 
		 * 放入Map单例池 -----> Bean对象
		 */
		AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService us = (UserService) application.getBean("userService");
		System.out.println(us);
		us.parseAdmin();
		/**
		 * Bean实例化, 实例化得到对象，使用构造方法
		 * Bean初始化  得到实例化的对象后，装填属性，方法
		 */
		
		/********************大致方法********************/
		
		
		
	}
}
