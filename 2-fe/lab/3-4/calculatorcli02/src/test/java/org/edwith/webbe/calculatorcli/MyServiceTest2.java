package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

// mockito가 제공하는 Junit 확장 클래스 MockitoJunitRunner를 이용해 테스트 클래스를 실행하도록 합니다.
@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest2 {
	
//	@InjectMocks 어노테이션이 붙은 필드는 목 객체를 사용하는 MyService 객체를 생성하여 초기화하라는 의미를 가집니다. 
//	myService 역시 여러분들이 초기화하지 않아도 자동으로 MyService 객체가 생성되어 초기화 됩니다.
	@InjectMocks
	MyService myService;

//	@Mock 어노테이션은 calculatorService가 목 객체를 참조하도록 합니다.
//	즉, 여러분이 객체를 생성하지 않아도 자동으로 객체가 생성되고 해당 필드가 초기화 된다는 것을 의미합니다.
	@Mock
	CalculatorService calculatorService;

	@Test
	public void execute() throws Exception {
		// given
		int value1 = 5;
		int value2 = 10;
		given(calculatorService.plus(5, 10)).willReturn(15);
//		given()은 static메소드입니다.
//		import문을 보면 org.mockito.BDDMockito 클래스의 static 메소드인것을 알 수 있습니다. 
//		calculatorService는 가짜 객체입니다. 이 가짜 객체가 동작하는 방법을 규정할 수 있는 것이 given()메소드입니다.
//		calculatorService.plus(5,10)을 호출하면 plus메소드가 15를 반환하도록 하라는 의미를 가집니다. 
		// when

		// when
		int result = myService.execute(value1, value2);
//		execute()메소드는 내부적으로 calculatorService의 plus메소드를 호출합니다. 
//		해당 메소드는 위에서 설정한대로만 동작합니다. 
//		value1과 value2가 무슨 값이든지 간에 result는 30을 반환할 것입니다.
		
		// then
		verify(calculatorService).plus(anyInt(), anyInt());
//		verify()메소드는 org.mockito.Mockito의 static한 메소드입니다. 
//		anyInt()메소드는 org.mockito.Matchers의 static한 메소드입니다. 
//		verify메소드는 파라미터로 들어온 객체의 plus메소드가 호출된 적이 있는지 검증합니다.
//		좀 더 자세히 살펴보자면 plus(anyInt(), anyInt())는 어떤 정수든지 2개를 파라미터로 넣어서
//		plus()메소드를 호출했는지를 검증합니다. 
//		myService.execute()메소드 내부적으로 plus 메소드를 호출했다면 해당 메소드는 검증을 성공한 것입니다.
//		만약, execute()메소드에서 plus(anyInt(), anyInt())를 호출하지 않았다면 오류가 발생하게 됩니다.
		Assert.assertEquals(30, result);
	}
}