package zdf.learn.com.SpringSourcePractise.lessons;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zdf.learn.com.SpringSourcePractise.lessons.lesson02pck.AppConfig;
import zdf.learn.com.SpringSourcePractise.lessons.lesson02pck.UserService;

/**
 * 
 * @Project       SpringSourcePractise
 * @CreatedTime   2023��3��7��
 * @Content       Spring��δ���Bean����---->������
 * @author        ZDF64
 *
 */
public class Lesson02 {
	
	public static void main(String[] args) {
		/**
		 * UserService�� ----> �޲ι��췽�� -----> ���� -----> ����ע��(DI) ------> ����Map������ -----> Bean����
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
