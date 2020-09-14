package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {
	public static void main(String[] args) {
		// 설정을 가지고 있는 클래스를 읽어들이면 됨. 클래스 파일을 읽도록.
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Car car = (Car) ac.getBean(Car.class); // "메서드 이름" 아님 Car의 클래스를 주세요
		car.run();
		
		((ConfigurableApplicationContext)ac).close();
		}

	
}
