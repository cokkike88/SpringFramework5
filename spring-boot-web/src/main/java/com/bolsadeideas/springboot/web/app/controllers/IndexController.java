package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	//@GetMapping(value = "/index")
	//@GetMapping("/index")
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring Framework!");
		return "index";
	}
	
	@GetMapping("/index2")
	public ModelAndView index2(ModelAndView mv) {
		mv.addObject("titulo", "Hola spring framework ModelAndView");
		mv.setViewName("index");
		return mv;
	}
	
}
