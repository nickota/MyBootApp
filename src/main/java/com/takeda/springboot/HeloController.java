package com.takeda.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.takeda.springboot.repositories.MyDataRepository;

@Controller
public class HeloController {
	//まずアプリケーションに用意されているBeanオブジェクトに関連づける
	@Autowired
	//自動的にインターフェイスに必要な処理が組み込まれたインスタンス化する
	MyDataRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(
			@ModelAttribute("forModel") MyData mydata,
			ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "this is sample content");
		Iterable<MyData> list = repository.findAll();  //JpaRepositoryに用意されている
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(
			@ModelAttribute("formModel") MyData mydata,
			ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}
	
	
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