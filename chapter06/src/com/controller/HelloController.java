package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	/*
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello(){ //사용자가 만든 콜백 메소드
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Have a nice day !");
		
//		mav.setViewName("hello"); // => /view/hello.jsp
		mav.setViewName("/view/hello"); // => /view/hello.jsp
		
		return mav;
	}
	*/
	
	@GetMapping(value="/hello.do", produces="text/html; charset=UTF-8")
	@ResponseBody
	public String hello() {
//		return "apple"; //apple.jsp
		return "안녕하세요 Spring !";
	}
	
	//스프링에서는 리턴 타입이 String이면 단순 문자열이 아니라 파일명으로 인식한다.
	//스프링은 apple.jsp 파일을 찾는다.
	//apple.jsp 파일이 아니라 단순 문자열로 웹에 나타나게 하려면 @ResponseBody를 써야 한다. -> viewresolver 거치지 않음 (produces="text/html; charset=UTF-8" 써줘야 한글나옴)
}
