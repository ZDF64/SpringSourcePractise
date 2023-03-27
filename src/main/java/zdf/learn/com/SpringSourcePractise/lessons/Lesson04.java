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
 * @CreatedTime   2023��3��7��
 * @Content       Spring��δ���Bean����---->������---->@PostConstruct����ԭ��----->InitializingBean�ӿ�ʵ��afterPropertiesSet����
 * ------>Beanʵ����,Bean��ʼ��
 * @author        ZDF64
 *
 */
public class Lesson04 {
	
	public static void main(String[] args) {
		/**
		 * UserService�� ----> �޲ι��췽�� -----> ���� -----> ����ע��(DI) -----> 
		 * ��ʼ��ǰ(ִ���ض�����) -----> ��ʼ�� -----> ��ʼ����(AOP) ------> 
		 * ����Map������ -----> Bean����
		 */
		AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService us = (UserService) application.getBean("userService");
		System.out.println(us);
		us.parseAdmin();
		/**
		 * Beanʵ����, ʵ�����õ�����ʹ�ù��췽��
		 * Bean��ʼ��  �õ�ʵ�����Ķ����װ�����ԣ�����
		 */
		
		/********************���·���********************/
		
		
		
	}
}
