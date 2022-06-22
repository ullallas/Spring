package com.controller;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

//@Component //xml에 bean으로 안잡아도 됨. 잡으려면 이거 지우고 잡기
@Controller
public class SungJukController {
	@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";
	}
	
	@PostMapping(value="/sungJuk/result.do")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		double avg = (double)tot / 3;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		model.addAttribute("sungJukDTO", sungJukDTO);
		return "/sungJuk/result";
	}
}
