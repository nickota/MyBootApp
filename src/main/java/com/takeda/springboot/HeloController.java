package com.takeda.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//このクラスはRestControllerですよ
public class HeloController {

	@RequestMapping("/")//サーバーが受け取るアドレス
	public String index() {
		return "Hello World!!";
	}
	
	String[] names = {"aa","bb","cc"};
	String[] mails = {"aa@google.com", "bb@google.com", "cc@google.com"};

	@RequestMapping("/{id}")
	public DataObject index(@PathVariable int id) {
		return new DataObject(id, names[id], mails[id]);
	}
}
	class DataObject{
		private int id;
		private String name;
		private String value;
		
		//コンストラクタ
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
