package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//ApplicationConfig == ApplicationContext한테 어떤 어떤 설정들을 읽어들여서 공장을 만들어줘요.

@Configuration
@Import({DBConfig.class}) // 설정파일을 나눠서 작성
// 나 ComponentScan으로 읽어낼 거야. 
// 자동으로 RoleDao에 Repository가 붙어있는 클래스를 Bean으로 등록해준 거랑 같은 역할 !!
@ComponentScan(basePackages = {"kr.or.connect.daoexam.dao"})

public class ApplicationConfig {

}
