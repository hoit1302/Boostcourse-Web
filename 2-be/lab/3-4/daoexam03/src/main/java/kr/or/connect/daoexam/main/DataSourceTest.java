package kr.or.connect.daoexam.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;

public class DataSourceTest {
	public static void main(String[] args) {
//		ApplicationConfig.class에 들어있는 설정 파일을 읽어들여가지고 ApplicationContext를 생성.
//		ApplicationContext가 IoC/DI 컨테이너 (공장)
//		이 컨테이너가 가지고 있는 getBean()이라는 메서드를 이용해서 DataSource라는 클래스를 요청
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class); // DataSource 객체 얻어내기
		try (Connection conn = ds.getConnection())
		// DataSource한테 getConnection() 메서드를 이용해 Connection을 얻어오기 
		{
			if (conn != null)
				System.out.println("접속 성공 !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ac).close();
	}
}
