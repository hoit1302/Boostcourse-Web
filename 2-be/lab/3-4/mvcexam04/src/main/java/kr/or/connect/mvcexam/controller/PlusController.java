package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusForm";
	} // 그냥 뷰만 찾아다가 뷰에 대한 정보만 넘겨주면 되니까 뷰의 이름(jsp)을 return
	
	@PostMapping(path = "/plus")
	public String plus(@RequestParam(name = "value1", required = true) int v1,
			@RequestParam(name = "value2", required = true) int v2, ModelMap modelMap) {
//		plusForm.jsp에서 form태그의 input의 value1을 v1에 value2를 v2를 지정
//		Spring이 제공하고 있는 ModelMap이라는 객체에 받아서 넣어줄 거래.
//		여기다가 넣어주면 알아서 Spring이 이 부분을 request scope에다가 알아서 매핑 시켜줍니다.
		int result = v1 + v2; 

		modelMap.addAttribute("value1", v1); // map의 key-value
		modelMap.addAttribute("value2", v2);
		modelMap.addAttribute("result", result);
		return "plusResult";
	}
	
}
