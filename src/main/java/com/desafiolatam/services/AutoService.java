package com.desafiolatam.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Auto;
import com.desafiolatam.repositories.AutoRepository;

@Service
public class AutoService {
	@Autowired
	AutoRepository autoRepository;

	public List<Auto> findAll() {
		return autoRepository.findAll();
	}

	public boolean guardarAuto(@Valid Auto auto) {
		Auto autoCreado = autoRepository.save(auto);
		if (autoCreado != null) {
			return true;
		}
		return false;
	}

	public void deleteById(Long id) {
		autoRepository.deleteById(id);
	}

	public Auto finById(Long id) {
		//para el retorno del mismo tipo de objeto usamos.get()
		return autoRepository.findById(id).get();
	}

	public void updateAuto(@Valid Auto auto) {
		autoRepository.save(auto);
		
	}
}