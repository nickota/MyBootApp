package com.takeda.springboot;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//このクラスはControllerですよ
public class HeloController {

	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("num", num);
		if (num >= 0) {
			mav.addObject("check", "num >= data.size() ? 0 : num");
		} else {
			mav.addObject("check", "num <= data.size() * -1 ? 0 : num * -1");
		}
		
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0, "taro", "taro@yamada"));
		data.add(new DataObject(1, "hanako", "hanako@flower"));
		data.add(new DataObject(2, "sachiko", "sachiko@com"));
		mav.addObject("data", data);
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
	
//	@RequestMapping("/{month}")
//	public ModelAndView index(@PathVariable int month, ModelAndView mav) {
//		mav.setViewName("index");
//		int m = Math.abs(month) % 12;
//		m = m == 0 ? 12 : m;
//		mav.addObject("month",m);
//		mav.addObject("check", Math.floor(m / 3));
//		return mav;
//	}
}

class DataObject {
	private int id;
	private String name;
	private String value;
	
	public DataObject(int id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}