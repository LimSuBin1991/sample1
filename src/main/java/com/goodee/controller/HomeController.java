package com.goodee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//서블릿을 대신하는 컨트롤러
//객체자체가 서블릿의 위아래 동작을 다 해주면서 빈 객체가 됨
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
		//index라는 문자열 리턴하면 앞에는 "/WEB-INF/views/" 뒤에는 ".jsp"를 붙여서 날려준다
		//즉 /WEB-INF/views/index.jsp로 날려준다는것
		
		
	}
	
}
