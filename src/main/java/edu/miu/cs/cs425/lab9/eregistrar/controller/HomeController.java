package edu.miu.cs.cs425.lab9.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value= {"/","/eregistrar","/eregistrar/home"})
	public String displayHomePage() {
		return "home/index";
	}
}
