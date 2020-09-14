package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith 어노테이션은 JUnit이 제공하는 어노테이션입니다.
//JUnit은 확장기능을 가지는데, 스프링에서는 JUnit을 확장하도록 SpringJUnit4ClassRunner.class를 제공합니다.
//해당 코드는 JUnit이 테스트 코드를 실행할 때 스프링 빈 컨테이너가 내부적으로 생성되도록 합니다.
@ContextConfiguration(classes = {ApplicationConfig.class})
//내부적으로 생성된 스프링 빈 컨테이너가 사용할 설정파일을 지정할 때 사용합니다.

//위에서 설명한 2줄이 테스트 클래스 위에 있으면, 테스트 클래스 자체가 빈(Bean)객체가 되어 스프링에서 관리되게 됩니다. 

public class CalculatorServiceTest {
	@Autowired
	CalculatorService calculatorService;
//	CalcultorServiceTest 클래스가 빈으로 관리되면서, 스프링 빈 컨테이너는 CalculatorService를 	주입(Inject)할 수 있게 됩니다. 
//	이렇게 주입된 클래스를 테스트하면 됩니다.



    @Test
    public void plus() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.plus(value1, value2);

        // then
        Assert.assertEquals(15, result); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divide() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService. divide (value1, value2);

        // then
        Assert.assertEquals(result, 2); // 결과와 2가 같을 경우에만 성공
    }

    @Test
    public void divideExceptionTest() throws Exception{
        // given
        int value1 = 10;
        int value2 = 0;

        try {
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }
        Assert.assertTrue(false); // 이부분이 실행되면 무조건 실패다. Assert.fail()과 동작같음

    }
}
