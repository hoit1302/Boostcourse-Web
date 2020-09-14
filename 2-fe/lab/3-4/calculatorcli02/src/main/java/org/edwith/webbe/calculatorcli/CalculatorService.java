package org.edwith.webbe.calculatorcli;

import org.springframework.stereotype.Component;

//스프링 빈 컨테이너에서 관리한다는 것은 개발자가 직접 인스턴스를 생성하지 않는다는 것을 의미합니다.
//스프링 빈 컨테이너가 인스턴스를 생성해 관리한다는 것을 뜻합니다.
@Component // 스프링 빈 컨테이너가 CalculatorService클래스를 찾아 빈으로 등록할 수 있도록 어노테이션.
public class CalculatorService {
	public int plus(int value1, int value2) {
		return value1 + value2;
	}

	public int minus(int value1, int value2) {
		return value1 - value2;
	}

	public int multiple(int value1, int value2) {
		return value1 * value2;
	}

	public int divide(int value1, int value2) throws ArithmeticException {
		return value1 / value2;
	}
}
