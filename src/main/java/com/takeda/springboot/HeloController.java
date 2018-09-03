package com.takeda.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//このクラスはControllerですよ
public class HeloController {

	@RequestMapping(value="/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/other")
	public String other() {
		//「/」にredirectしてる
		return "redirect:/";
	}
	
	@RequestMapping(value="/home")
	public String home() {
		//「/」にforwardしてる
		return "forward:/";
	}
}