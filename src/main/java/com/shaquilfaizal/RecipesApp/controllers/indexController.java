package com.shaquilfaizal.RecipesApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {


	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		return "index";
	}
	
	
}
