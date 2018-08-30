package com.takeda.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//このクラスはControllerですよ
public class HeloController {

	@RequestMapping("/{num}")//サーバーが受け取るアドレス
	public String index(@PathVariable int num, Model model) {
		//テンプレート名。pom.xmlでspring-boot-starter-thymeleafを指定してるから使える
		int res = 0;
		for (int i = 1; i <= num; i++) {
			res += i;
		}
		model.addAttribute("msg", "total: " + res);
		return "index";
	}
}