package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	public String input() {
		return "/sum/input";
	}
	
//	@GetMapping(value="/result.do")
//	public String result() {
//		return "/sum/result";
//	}
	
//	@GetMapping(value="/result.do")
//	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@GetMapping(value="/result.do")
//	public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x, 
//							   @RequestParam(required = false, defaultValue = "0") String y) { //int, String 둘 다 가능. 오류나면 int로 바꾸기
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", x);
//		mav.addObject("y", y);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@GetMapping(value="/result.do")
//	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) { //위와 같음
//		
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		return "/sum/result";
//	}
	
	@GetMapping(value="/result.do")
	public String result(@ModelAttribute SumDTO sumDTO, Model model) { 
		
		model.addAttribute("sumDTO", sumDTO);
		return "/sum/result";
	}
}
