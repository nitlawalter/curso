package com.walter.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.curso.domain.Categoria;
import com.walter.curso.repositories.CategoriaRepository;
import com.walter.curso.services.exceptions.ObjetoNaoEncontradoException;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException("Objeto não encontrado! id: " + id) ); 
	}

}
