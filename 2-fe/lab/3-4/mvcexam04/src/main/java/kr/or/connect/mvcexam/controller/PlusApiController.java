package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.mvcexam.dto.PlusResult;

// Web Api
@Controller
public class PlusApiController {
	@GetMapping("/api/plus")
    @ResponseBody //해당 메소드는 뷰이름을 리턴(보통은 그럼)하는 것이 아니라, 리턴한 객체를 출력하라는 의미
    public PlusResult plus(@RequestParam("value1") int value1, @RequestParam("value2") int value2){
        PlusResult plusResult = new PlusResult();
        plusResult.setValue1(value1);
        plusResult.setValue2(value2);
        plusResult.setResult(value1 + value2);
        return plusResult;
    }
}
