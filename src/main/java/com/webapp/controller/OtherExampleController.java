package com.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OtherExampleController {
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String authorInfo(Model model) {
		
		return "redirect:/user.do";
	}
}
