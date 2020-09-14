package org.edwith.webbe.calculator.service;

import org.springframework.stereotype.Service;

//CalculatorService클래스는 컴포넌트 스캔을 통해 자동으로 Bean으로 등록됩니다.

@Service // bean 자동 등록
public class CalculatorService {
    public int plus(int value1, int value2){
        return value1 + value2;
    }

    public int minus(int value1, int value2){
        return value1 - value2;
    }
}