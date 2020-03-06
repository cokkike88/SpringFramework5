package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	//@GetMapping(value = "/index")
	//@GetMapping("/index")
	@GetMapping({"/index", "/", "", "/home"})	
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring Framework!");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Oscar");
		usuario.setApellido("Liss");
		usuario.setEmail("oscarlisss@gmail.com");
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar (Model model) {
		
		/*List<Usuario> lstUsuarios = new ArrayList<>();		
		lstUsuarios.add(new Usuario("Oscar", "Munoz", "omunoz@gmail.com"));
		lstUsuarios.add(new Usuario("Liss", "Gomez", "lgomez@gmail.com"));
		lstUsuarios.add(new Usuario("Caleb", "Munoz", "cmunoz@gmail.com"));*/		
		
		model.addAttribute("titulo", "Listado Usuarios");

		return "listar";
	}
	
	// Pasa datos a todas las vistas del controllador
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> lstUsuarios = Arrays.asList(
				new Usuario("Oscar", "Munoz", "omunoz@gmail.com"),
				new Usuario("Liss", "Gomez", "lgomez@gmail.com"),
				new Usuario("Caleb", "Munoz", "cmunoz@gmail.com")
				);
		return lstUsuarios;
	}
	
}
