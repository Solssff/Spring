package com.desafiolatam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

//1. restcontroller nos permite capturar la ruta
@RestController

public class HomeController {


	@RequestMapping("/hola")
	public String saludo() {
		return "Hola desde el metodo saludo";
	}

	@RequestMapping("/parametro")
	// http://localhost:8080/parametro?nombre=Soledad&apellido=Silva esta es la ruta
	// de la captura del nombre
	public String parametro(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "apellido") String apellido) {
		return "Hola, " + nombre + " " + apellido;
	}

	// capturando variables desde el path o ruta

	// http://localhost:8080/fecha/anio/2022/mes/3/dia/7
	@RequestMapping("/fecha/anio/{anio}/mes/{mes}/dia/{dia}")
	public String obtenerFecha(@PathVariable("anio") Integer anio, @PathVariable("mes") Integer mes,
			@PathVariable("dia") Integer dia) {

		return "Fecha de hoy: "+ dia+"/"+mes+"/"+anio; //Fecha de hoy: 7/3/2022

	}

	// http://localhost:8080/fecha/2022/3/7
	@RequestMapping("/fecha/{anio}/{mes}/{dia}")
	public String obtenerFecha2(@PathVariable("anio") Integer anio, @PathVariable("mes") Integer mes,
			@PathVariable("dia") Integer dia) {

		return "Fecha de hoy: "+ dia+"/"+mes+"/"+anio;
	}

}
