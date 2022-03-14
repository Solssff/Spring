package com.desafiolatam.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	public void guardarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		
	}
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}


}
