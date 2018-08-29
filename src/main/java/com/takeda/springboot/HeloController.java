package com.takeda.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//このクラスはControllerですよ
public class HeloController {

	@RequestMapping("/")//サーバーが受け取るアドレス
	public String index() {
		return "index";
	}
}