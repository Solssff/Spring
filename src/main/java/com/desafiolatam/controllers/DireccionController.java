package com.desafiolatam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.models.Direccion;
import com.desafiolatam.services.ClienteService;
import com.desafiolatam.services.DireccionService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {

	@Autowired
	DireccionService direccionService;
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping("")
	public String desplegar(@ModelAttribute("direccion") Direccion direccion,
			Model model) {
		List<Cliente>listaClientes=clienteService.findAll();
		model.addAttribute("listaClientes", listaClientes);
		return "direccion.jsp";
	}
	
	@RequestMapping("/crear")
	public String guardarDireccion( @Valid @ModelAttribute("direccion") Direccion direccion, 
			BindingResult result,
			Model model) {
			direccionService.guardarDireccion(direccion);
		return "redirect:/auto/home";
	}
}
