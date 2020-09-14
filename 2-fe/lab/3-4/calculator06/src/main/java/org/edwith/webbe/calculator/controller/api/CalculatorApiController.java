package org.edwith.webbe.calculator.controller.api;

import io.swagger.annotations.*;
import org.edwith.webbe.calculator.dto.CalculatorResult;
import org.edwith.webbe.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController // 응답 결과를 json으로 해야하기 때문에.
@RequestMapping(path = "/api/calculator") //PATH가 공통적으로 "/api/calculator"로 하기 위해서
public class CalculatorApiController {	
    @Autowired
    private CalculatorService calculatorService;
    
//  @ApiOperation과 @ApiResponse는 스웨거가 제공하는 어노테이션
    // 간단한 설명으로 화면에서 쉽게 확인 가능
    @ApiOperation(value = "덧셈 구하기")
    @ApiResponses({  //  Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping("/plus")
    public CalculatorResult plus(@RequestParam("value1")int value1, @RequestParam("value2") int value2){
        CalculatorResult calculatorResult = new CalculatorResult();
        calculatorResult.setValue1(value1);
        calculatorResult.setValue2(value2);
        calculatorResult.setOperation(CalculatorResult.PLUS_OPERATION);
        calculatorResult.setResult(calculatorService.plus(value1, value2));
        return calculatorResult;
    }

    @ApiOperation(value = "뺄셈 구하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    
    @GetMapping("/minus")
    public CalculatorResult minus(@RequestParam("value1")int value1, @RequestParam("value2") int value2){
        CalculatorResult calculatorResult = new CalculatorResult();
        calculatorResult.setValue1(value1);
        calculatorResult.setValue2(value2);
        calculatorResult.setOperation(CalculatorResult.MINUS_OPERATION);
        calculatorResult.setResult(calculatorService.minus(value1, value2));
        return calculatorResult;
    }
}