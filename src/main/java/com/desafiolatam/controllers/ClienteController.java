package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@RequestMapping("")
	public String desplegar(@ModelAttribute("cliente") Cliente cliente) {
		return "cliente.jsp";
	}
	
	@RequestMapping("/crear")
	public String crearCliente( @Valid @ModelAttribute("cliente") Cliente cliente, 
			BindingResult result,
			Model model) {
			clienteService.guardarCliente(cliente);
		return "redirect:/direccion";
	}
	
}
