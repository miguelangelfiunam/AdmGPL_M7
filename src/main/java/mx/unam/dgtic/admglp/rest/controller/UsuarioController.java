package mx.unam.dgtic.admglp.rest.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.dgtic.admglp.dao.Usuario;
import mx.unam.dgtic.admglp.repository.UsuarioRepository;

@RestController
@RequestMapping("/usu")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public Iterable<Usuario> findAll(@RequestParam Map<String, String> parametros) {
		Iterable<Usuario> usuarios = null;
		int leidos = 0;
		if (leidos == 0) {
			usuarios = usuarioRepository.findAll();
		}
		return usuarios;
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarMatricula(@PathVariable Integer idUsuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		if (optional.isPresent()) {
			Usuario u = optional.get();
			return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

}
