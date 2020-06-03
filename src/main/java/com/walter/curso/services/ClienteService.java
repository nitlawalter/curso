package com.walter.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.curso.domain.Cliente;
import com.walter.curso.repositories.ClienteRepository;
import com.walter.curso.services.exceptions.ObjetoNaoEncontradoException;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException("Objeto não encontrado! id: " + id) ); 
	}

}
