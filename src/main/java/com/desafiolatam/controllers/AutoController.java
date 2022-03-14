package com.desafiolatam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Auto;
import com.desafiolatam.services.AutoService;

@Controller
@RequestMapping("/auto")
public class AutoController {
	@Autowired
	AutoService autoService;

	@RequestMapping("/home")
	public String home(Model model, HttpSession session) {
		String emailSession= (String)session.getAttribute("emailUsuario");
	
		
		List<Auto> listaAutos = autoService.findAll();
		model.addAttribute("listaAutos", listaAutos);
		return "auto.jsp";
	}

	//crear 
	@RequestMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("auto", new Auto());
		return "crearAuto.jsp";
	}
	
	// auto/actualizar/{id}
		@RequestMapping("/insertar")
		public String insertar(@Valid @ModelAttribute ("auto") Auto auto, 
			BindingResult resultado){
				if(resultado.hasErrors()) {
					//retornar mensaje de error
				}else {
					//actualizar en base de datos el objeto
					autoService.updateAuto(auto);
					
				}
			return "redirect:/auto/home";
		}
	
	// auto/editar/{id}
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		//obtener el auto con el id
		Auto auto=autoService.finById(id);
		model.addAttribute("auto",auto);
		return "editarAuto.jsp";
	}

	// auto/actualizar/{id}
	@RequestMapping("/actualizar/{id}")
	public String actualizar(@Valid @ModelAttribute ("auto") Auto auto, 
		BindingResult resultado){
			if(resultado.hasErrors()) {
				//retornar mensaje de error
			}else {
				//actualizar en base de datos el objeto
				autoService.updateAuto(auto);
				
			}
		return "redirect:/auto/home";
	}
	
	// autito/eliminar/{id}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		autoService.deleteById(id);
		return "redirect:/auto/home";
	}

}
