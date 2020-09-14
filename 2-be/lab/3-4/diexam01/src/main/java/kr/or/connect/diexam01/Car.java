package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired //네가 알아서 Engine 타입의 객체가 생성된 게 있으면 v8에 주입해 줘.
	private Engine v8;

	public Car() {
		System.out.println("car 생성자");
	}

	public void setEngine(Engine e) {
		this.v8 = e;
	}

	public void run() {
		System.out.println("엔진을 이용하여 달립니다");
		v8.exec();
	}

//	public static void main(String[] args) {
//		Engine e = new Engine();
//		Car c = new Car();
//		c.setEngine(e);
//		c.run();
//	}
}
