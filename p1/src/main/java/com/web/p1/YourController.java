package com.web.p1; //삭제하지 말 것.

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller // 매우 중요 ****  무조건 붙여줄 것. 
public class YourController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login/check")
	public String loginCheck(HttpSession se, 
					@RequestParam("mid") String mid, RedirectAttributes re) {
		
		var arr = new ArrayList<String>();
		arr.add("고흐");
		arr.add("james");
		arr.add("dooli");
		arr.add("iu");
		
		if( arr.contains(mid))
		{
				se.setAttribute("mid", mid);
				return "redirect:/menu";
		}
		else
		{
				re.addAttribute("msg", mid
						+ "는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
				return "redirect:/popup";
		}
	}
	@GetMapping("/popup")
	public String popup(@RequestParam("msg") String msg, Model mo) {
		mo.addAttribute("msg", msg);
		return "popup";
	}
	@GetMapping("/menu")
	public String menu(HttpSession se, Model mo) {
		mo.addAttribute("mid", se.getAttribute("mid"));
		return "menu";
	}
	@GetMapping("/coffee")
	public String coffee(HttpSession se, Model mo) {
		mo.addAttribute("mid", se.getAttribute("mid"));
		return "coffee";
	}
	@GetMapping("/logout")
	public String logout(HttpSession se, Model mo) {
		mo.addAttribute("mid", se.getAttribute("mid"));
		se.invalidate();
		return "logout";
	}
}
