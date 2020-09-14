package kr.or.connect.daoexam.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //트랜잭션을 위해
public class DBConfig {
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private String username = "connectuser";
	private String password = "connect123!@#";
	
//	우리는 DataSource라는 걸 통해서 DB에 접속하는 부분들을 얻어내기로 했잖아요? (pom.xml에도 추가)
	@Bean
	public DataSource dataSource() { // 메서드의 이름은 bean 등록할 때 id로 지정하는 이름과 같음
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
