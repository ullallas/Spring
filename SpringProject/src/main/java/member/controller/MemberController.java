package member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@PostMapping(value="login")
	@ResponseBody
	public String login(@RequestParam Map<String, String> map) {
		return memberService.login(map);
	}
	
	@PostMapping(value="logout")
	@ResponseBody
	public void logout() {
		memberService.logout();
	}
	
	@GetMapping(value="writeForm")
	public ModelAndView writeForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("nav", "/WEB-INF/main/nav.jsp");
		mav.addObject("display", "/WEB-INF/member/writeForm.jsp");
		mav.setViewName("/index");
		
		return mav;
	}
	
	@PostMapping(value="checkId")
	@ResponseBody
	public String checkId(@RequestParam String id) {
		return memberService.checkId(id);
	}
	
	@PostMapping(value="write")
	@ResponseBody
	public void write(@ModelAttribute MemberDTO memberDTO) {
		memberService.write(memberDTO);
	}
	
	@GetMapping(value="updateForm")
	public ModelAndView updateForm() {
//		String id = (String) session.getAttribute("memId");
//		MemberDTO memberDTO = memberService.getMember(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", "/WEB-INF/main/menu.jsp");
		mav.addObject("nav", "/WEB-INF/main/nav.jsp");
		mav.addObject("display", "/WEB-INF/member/updateForm.jsp");
		mav.setViewName("/index");
		
		return mav;
	}
	
	@PostMapping(value="getMember")
	@ResponseBody 
	public MemberDTO getMember(HttpSession session) {
		String id = (String) session.getAttribute("memId");
		return memberService.getMember(id);
	}
	
	@PostMapping(value="update")
	@ResponseBody
	public void update(@ModelAttribute MemberDTO memberDTO) {
		memberService.update(memberDTO);
	}
}
