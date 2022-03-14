package com.desafiolatam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.desafiolatam.models.Usuario;
import com.desafiolatam.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	// http://localhost:8080/usuario/
	@RequestMapping("/")
	public String inicioUsuario() {
		return "Hola desde el controlador usuario";
	}

	// http://localhost:8080/usuario/editar
	@RequestMapping("/editar")
	public String editar() {
		return "metodo editar en ususario controller";
	}

	// http://localhost:8080/usuario/editar/bloqueos
	@RequestMapping("/editar/bloqueos")
	public String editarBloqueos() {
		return "metodo editarBloqueos en ususario controller";
	}

	// http://localhost:8080/usuario/registro
	@RequestMapping("/registro")
	public String registro(Model model, @ModelAttribute("usuario") Usuario usuario) {
		model.addAttribute("titulo", "Mi pagina");
		return "registro.jsp";
	}

	// http://localhost:8080/usuario/formulario
	@RequestMapping("/formulario")
	/*public String formulario(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "apellido") String apellido, 
			@RequestParam(value = "correo") String correo,
			@RequestParam(value = "password") String password, 
			@RequestParam(value = "genero") String genero,
			Model model) {
		
		//VALIDACION
		if(nombre.isEmpty()||apellido.isEmpty()||correo.isEmpty()||password.isEmpty()|| genero==null) {
			model.addAttribute("titulo", "Mi pagina");
			model.addAttribute("msgError", "Debe ingresar todos los campos");
			return "registro.jsp";
		}else {
			Usuario usuario = new Usuario(nombre, apellido, correo, password, Integer.parseInt(genero));
			// PENDIENTE LA PERSISTENCIA DE LA BASE DE DATOS
			usuarioService.guardarUsuario(usuario);
		}
		return "redirect:/usuario/showlogin"; //llamando a otra ruta
	}*/
	
	public String formulario( @Valid @ModelAttribute("usuario") Usuario usuario, 
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msgError", "Debe ingresar todos los campos");
			return "registro.jsp";
		}else {
			boolean resultado = usuarioService.guardarUsuario(usuario);
			if(resultado) {
				return "redirect:/usuario/showlogin";
			}else {
				model.addAttribute("msgError", "Correo ya existe");
				return "registro.jsp";
			}

		}

	}
	
	//mostrar el jsp
	@RequestMapping("/showlogin")
	public String showlogin(Model model) {
		model.addAttribute("titulo", "Mi pagina");
		return "login.jsp";
	}
	
	//capturar los datos desde el jsp
		@RequestMapping("/login")
		public String login(@RequestParam(value="email") String email,
				@RequestParam(value="password") String password, Model model, HttpSession session) {
			//System.out.println("password "+ password);
			//System.out.println("email "+ email);
			if(email.equals("") || password.equals("")) {
				model.addAttribute("msgError","Completar todos los campos obligatoriamente");
				return"login.jsp";
			}
			boolean logueado= usuarioService.login(email,password);
			if(logueado) {
				return"/home";
			}else {
				model.addAttribute("msgError","Error al ingresar al sistema");
				return"login.jsp";
			}
		}
	

}
