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
 * @CreatedTime   2023��3��7��
 * @Content       Spring��δ���Bean����---->������---->@PostConstruct����ԭ��
 * @author        ZDF64
 *
 */
public class Lesson03 {
	
	public static void main(String[] args) {
		/**
		 * UserService�� ----> �޲ι��췽�� -----> ���� -----> ����ע��(DI) -----> ��ʼ��ǰ(ִ���ض�����) -----> ��ʼ�� -----> ��ʼ���� ------> ����Map������ -----> Bean����
		 */
		AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService us = (UserService) application.getBean("userService");
		System.out.println(us);
		
		
		/********************���·���********************/
		
		try {
			UserService user = new UserService();
			for(Field f: user.getClass().getDeclaredFields()) {
				if(f.isAnnotationPresent(Autowired.class)) {
					f.setAccessible(true);
					System.out.println("������:"+f.getName());
					System.out.println("��������:"+f.getGenericType().getTypeName());
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
