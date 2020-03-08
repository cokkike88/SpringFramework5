package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	// /params/string?texto=valor del texto
	public String param(@RequestParam(required = false, defaultValue = "algu valor...") String texto, Model model) {
		model.addAttribute("resultado", "El parametro enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String parma(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo es saludo: '" + saludo + "' y el numero es '" + numero + "'") ;
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String parma(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = 0;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}
		catch(NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El saludo es saludo: '" + saludo + "' y el numero es '" + numero + "'") ;
		return "params/ver";
	}
}
