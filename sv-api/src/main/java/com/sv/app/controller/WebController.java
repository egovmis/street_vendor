package com.sv.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/web" })
public class WebController {
	
	@RequestMapping("/hello")
	   public String index() {
		System.out.println("=============================");
	      return "index";
	   }


}
