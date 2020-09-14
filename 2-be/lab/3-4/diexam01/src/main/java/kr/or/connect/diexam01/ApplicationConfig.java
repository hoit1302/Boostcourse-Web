package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml 설정을 대체할 수 있는 Java Config
//자바 클래스 파일을 설정 파일로 사용

@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
