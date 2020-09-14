package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {
	public static void main(String[] args) {
		// ClassPath에서 설정을 읽어옴
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car = (Car) ac.getBean("c"); // 등록했던 bean id 주기
		car.run();
		
		((ConfigurableApplicationContext)ac).close();
		}
}
