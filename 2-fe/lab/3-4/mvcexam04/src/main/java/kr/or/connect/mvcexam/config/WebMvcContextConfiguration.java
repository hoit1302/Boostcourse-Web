package kr.or.connect.mvcexam.config;

//DispatcherServlet이 실행될 때 읽어들이는 설정 파일
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Spring MVC 설정
@Configuration
// 나 설정config 파일이에요
@EnableWebMvc
//@EnableWebMvc 를 이용하면 기본적인 설정이 모두 자동으로 되지만, 
//기본 설정 이외의 설정이 필요할 경우 WebMvcConfigurer 클래스를 상속 받은 후, 메소드를 오버라이딩 하여 구현한다.
@ComponentScan(basePackages = { "kr.or.connect.mvcexam.controller" })
// controller, service, repository, component 애노테이션이 붙은 클래스를 찾아 스프링 컨테이너가 관리.
public class WebMvcContextConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	} // URL 요청이 여기처럼 /css, /img, /js 이렇게 들어오는 것들은 어떻게 처리해주세요.

	// default servlet handler를 사용하게 합니다.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	} // default servlet handler를 사용할 수 있게 해주는 설정
//    이 부분은 매핑 정보가 없는 URL 요청이 들어왔을 때 매핑 정보가 없는 URL 요청은 Spring의 
//    DefaultServletHttpRequsetHandler가 처리하도록 해주게 하는 거잖아요.

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다. ");
		registry.addViewController("/").setViewName("main");
	} // 특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해주는 부분
//    그래서 "/"라고 요청이 들어오면 "main"라는 이름의 뷰로 보여주세요.

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	} // 뷰 지정. main 앞에 /WEB-INF/views/ 붙이고 뒤에 .jsp 붙여서
//	결국 WEB-INF/views/main.jsp라는 파일을 찾아주는 것. 이게 뷰가 되는 것.
}