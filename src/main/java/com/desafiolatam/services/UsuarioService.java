package com.desafiolatam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	// se realiza la logica de negocio

	public boolean guardarUsuario(Usuario usuario) {
		Usuario usuarioRetorno = usuarioRepository.findByCorreo(usuario.getCorreo());
		if (usuarioRetorno == null) {
			usuarioRepository.save(usuario);
			return true;
		}else {
			return false;
		}
	}

	public boolean login(String email, String password) {

		// buscar si existe un ususario con ese email
		Usuario usuario = usuarioRepository.findByCorreo(email);
		if (usuario != null) { //si existe o no
			// System.out.println(usuario.getNombre());
			if (usuario.getPassword().equals(password)) { //aca validamos si los password son iguakles 
				return true;
			} else {
				return false; //password distintos
			}
		} else {
			return false; //no existe ese email
		}
	}
}

/*
 * public void login(String email, String password) { //buscar si existe un
 * ususario con ese email //luego si existe hay que comparar los password
 * //password iguales pueden acceder //, sino, regresar un mensaje de vuelta al
 * login }
 */
