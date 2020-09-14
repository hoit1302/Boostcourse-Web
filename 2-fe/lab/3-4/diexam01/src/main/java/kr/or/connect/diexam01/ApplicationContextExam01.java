package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	public static void main (String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		 공장한테 "여기에 내가 빈 정보 넣어 놓았으니까 이 정보를 읽어드려서 공장을 세워요." 알려주기
		System.out.println("초기화 완료!!");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
//		xml파일에서 String을 보내준 값과 같은 id를 찾아서 class를 생성 후 리턴
//		형변환하는 이유: Object type으로 반환하기 때문에
		userBean.setName("Kang");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		if (userBean == userBean2)
			System.out.println("같은 인스턴스입니다."); // ?????
//		싱글턴 패턴을 이용해요
//		그러니까 사용자가 계속 getBean() 해서 요청을 한다고 하더라도
//		그 객체를 계속 만들어내는 게 아니라 하나 만든 bean을 이용하는 거다.
//		이 bean 공장이 싱그런 패턴을 이용해서 bean들을 생성하는구나.
		
		((ConfigurableApplicationContext)ac).close();
		
	}
}	
