package com.spring.eli.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.eli.repository.UsuarioRepository;

@Transactional
@Component
public class PopulaBanco implements CommandLineRunner{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
	/*
		Usuario usu1 = new Usuario();
		usu1.setNome("Maria");
		usu1.setCpf("111 222 333 44");
		usu1.setDataNascimento(LocalDate.of(2000, 10, 10));
		usu1.setEmail("maria@maria");
		usu1.setTelefone("61 3333 4444");
		
		Usuario usu2 = new Usuario();
		usu2.setNome("Mary");
		usu2.setCpf("222 333 444 55");
		usu2.setDataNascimento(LocalDate.of(1999, 05, 9));
		usu2.setEmail("maria@maria");
		usu2.setTelefone("61 3333 4444");
		
		usuarioRepository.save(usu1);
		usuarioRepository.save(usu2);
	*/	
	}

}
