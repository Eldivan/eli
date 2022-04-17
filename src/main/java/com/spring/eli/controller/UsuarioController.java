package com.spring.eli.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.eli.model.Usuario;
import com.spring.eli.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/")
	public String  home() {
		return "cadastro/home";
	}
	
	@GetMapping("/paginacadastrousuario")
	public String cadastrausuarioform (@ModelAttribute("usuario") Usuario usuario) {
		return "cadastro/formulariocadastrousuario";
	}
	
	@PostMapping("/salvar")
	public String  salvar(@ModelAttribute("usuario") Usuario usuario) {
		usuarioRepository.save(usuario);
		return "/cadastro/home";
		
	}
	
	@GetMapping("/usuarioscadastrados")
	public String listapessoas(Model model) {
		model.addAttribute("listaUsuarios", usuarioRepository.findAll());
		return "/cadastro/home";
		
	}
	
	
	@GetMapping("/usuarioscadastrados/{id}")
	public String alterarUsuario(@PathVariable("id") long id, Model model) {
		 
		Optional<Usuario> usuariOpt = usuarioRepository.findById(id);
		if (usuariOpt.isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		model.addAttribute("usuario", usuariOpt.get());
		
		return "cadastro/formulariocadastrousuario";
		
	}
	
	@GetMapping("/excluirusuario/{id}")
	public String excluirUsuario(@PathVariable("id") long id, Model model) {
		 
		Optional<Usuario> usuariOpt= usuarioRepository.findById(id);
		if (usuariOpt.isEmpty()) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		usuarioRepository.delete(usuariOpt.get());
		
		return "redirect:/usuarioscadastrados";
		
	}
	
	
	
}
