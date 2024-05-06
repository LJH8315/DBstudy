package com.web.p1;

import java.util.ArrayList; //Ctrl + Shift + O

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class MyController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01";
	}
	@PostMapping("/ex01/answer")
	public String ex01Answer(@RequestParam(name="mid") String mid, @RequestParam(name="password") String password, Model mo) { //Model이 하는 것은 컨트롤러 -> html파일로 보내줄 때
	mo.addAttribute("mid", mid);
	mo.addAttribute("password", password);
	return "ex01Answer";
	}
	@GetMapping("/ex02")
	public String ex02() {
		return "ex02";
	}
	@PostMapping("/ex02/answer")
	public String ex02Answer(@RequestParam(name="mname") String mname, @RequestParam(name="po") String po, Model mo) {
	mo.addAttribute("mname", mname);
	mo.addAttribute("po", po);
	int salary = 0;
	switch(po) {
	case "사원" -> salary = 3500;
	case "대리" -> salary = 5000;
	case "팀장" -> salary = 7000;
	case "임원" -> salary = 9500;
	}
	mo.addAttribute("salary", salary);
	return "ex02Answer";
	}
	@GetMapping("/ex03") 
	public String ex03() {
		return "ex03"; //순서 1 : 화면을 고객에게 내보이면 역할 끝.
	}
	@PostMapping("/ex03/answer")
	public String ex03Answer(@RequestParam("mname") String mname, @RequestParam("color") String color, Model mo) {
	mo.addAttribute("mname", mname);
	mo.addAttribute("color", color);
	return "ex03Answer";
	}
	@GetMapping("/ex04")
	public String ex04(Model mo) {
		var arr = new ArrayList<String>();
		arr.add("고흐");
		arr.add("james");
		arr.add("dooli");
		arr.add("bread");
		
		mo.addAttribute("arr",arr);
		
		return "ex04";
	}
	@GetMapping("/ex05")
	public String ex05(Model mo) {
		var arr1 = new ArrayList<Integer>();
		arr1.add(10);
		arr1.add(20);
		arr1.add(30);
		arr1.add(40);
		arr1.add(50);
		
		var arr2 = new ArrayList<String>();
		arr2.add("배경이 심심해서");
		arr2.add("linear-gradient");
		arr2.add("사용을 해보았습니다");
		arr2.add("벌써");
		arr2.add("시험기간");
		arr2.add("이라니");
		arr2.add("(ㅠ_ㅠ)");
		
		mo.addAttribute("arr1",arr1);
		mo.addAttribute("arr2",arr2);
		
		return "ex05";
	}
	@GetMapping("/wise")
	public String wise() {
		return "wise";
	}
	@PostMapping("/wise/answer")
	public String wiseAnswer(@RequestParam("wise") String wise, @RequestParam("wi") String wi, Model mo) {
	mo.addAttribute("wise", wise);
	mo.addAttribute("wi", wi);
	return "wiseAnswer";
	}
	@GetMapping("/bread")
	public String bread() {
		return "bread";
	}
	@PostMapping("/bread/answer")
	public String breadAnswer(@RequestParam("bread") String bread, @RequestParam("price") Integer price, @RequestParam("num") Integer num, Model mo) {
	mo.addAttribute("bread", bread);
	mo.addAttribute("price", price*num);
	mo.addAttribute("num", num);
		return "breadAnswer";
	}
	@GetMapping("/q06")
	public String q06() {
		return "q06";
	}
	@GetMapping("/q06/a")
	public String q06a() {
		return "q06a";
	}
	@GetMapping("/q06/aa")
	public String q06aa(@RequestParam("company1") String company1, @RequestParam("company2") String company2, Model mo) {
	mo.addAttribute("company1", company1);
	mo.addAttribute("company2", company2);
		return "q06aa";
	}
	@GetMapping("/q06/b")
	public String q06b() {
		return "q06b";
	}
	@GetMapping("/q06/bb")
	public String q06bb(@RequestParam("job") String job, Model mo) {
	mo.addAttribute("job", job);
		return "q06bb";
	}
	@GetMapping("/popuptest")
	public String popuptest() {
		return "popuptest";
	}
} //class
