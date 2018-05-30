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
	
	@RequestMapping("/test.do")
	public String hello1(Model model) {
		
		System.out.println("/test.do");
		
		model.addAttribute("greeting", "SP-2");
		model.addAttribute("test", "test");

		return "helloworld";
	}
}
