package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		
		model.addAttribute("greeting", "Hello Spring MVC");
		
		return "helloworld";
	}
	
	@RequestMapping("/fuck.do")
	public String hello1(Model model) {
		
		model.addAttribute("greeting", "FuckOff");
		return "helloworld";
	}
}