package org.edwith.webbe.calculatorcli;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//스프링 프레임워크를 사용하기 위해서는 설정 파일을 작성해야한다.
//스프링 설정파일은 xml 파일이나 Java Config로 작성할 수 있는데 이거는 Java Config파일이다
@Configuration // 나 스프링 설정 파일이야. 스프링 설정파일은 스프링 빈 컨테이너인 ApplicationContext에서 읽어들인다
@ComponentScan(basePackages = {"org.edwith.webbe.calculatorcli"}) //특정 패키지 이하에서 컴포넌트를 찾도록 합니다.
public class ApplicationConfig {

}
