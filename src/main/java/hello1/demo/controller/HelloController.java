package hello1.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이게 핵심 controller
public class HelloController {

	@GetMapping("hello") //Get메소드를 불러오는 것 슬러쉬(/) 이후
	public String hello(Model model) { // 모델을 가지고 오는것 
		model.addAttribute("data","hello!!"); //모델의 메소드로써 key : data, value : hello!! 담는다 --> hello.html에서  ${data} 모델의 키값을 받아와서 치환해준다
		return "hello"; // resource/template 에서 hello.html을 호출 하는 것
	}
	
	// 매개변수 받아오기
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody //http의 body에 문자 내용을 직접 반환
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("hello-api")
	@ResponseBody // 객체를 보내기 때문에 JSON(키와 값형식) 방식 이용 
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}
	
	static class Hello {
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
