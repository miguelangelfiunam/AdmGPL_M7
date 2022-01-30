package mx.unam.dgtic.admglp.rest.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		boolean bNombre = parametros.containsKey("nombre");
		String nombre = parametros.get("nombre");
		boolean bApellido1 = parametros.containsKey("apellido1");
		String apellido1 = parametros.get("apellido1");
		boolean bApellido2 = parametros.containsKey("apellido2");
		String apellido2 = parametros.get("apellido2");

		if (bNombre && bApellido1 && bApellido2) {
			usuarios = usuarioRepository.findByNombreAndApellido1AndApellido2(nombre, apellido1, apellido2);
		} else if (bNombre && bApellido1) {
			usuarios = usuarioRepository.findByNombreOrApellido1(nombre, apellido1);
		} else if (bNombre && bApellido2) {
			usuarios = usuarioRepository.findByNombreOrApellido1(nombre, apellido2);
		} else if (bApellido1 && bApellido2) {
			usuarios = usuarioRepository.findByApellido1OrApellido2(apellido1, apellido2);
		} else if (bNombre) {
			usuarios = usuarioRepository.findByNombre(nombre);
		} else if (bApellido1) {
			usuarios = usuarioRepository.findByApellido1(apellido1);
		} else if (bApellido2) {
			usuarios = usuarioRepository.findByApellido2(apellido2);
		} else {
			usuarios = usuarioRepository.findAll();
		}
		return usuarios;
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer idUsuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		if (optional.isPresent()) {
			Usuario u = optional.get();
			return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void agregarUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@PutMapping("/{idUsuario}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizaAlumno(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		if (optional.isPresent()) {
			Usuario a = usuario;
			a.setIdUsuario(idUsuario);
			usuarioRepository.save(a);
		}
		
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Usuario> eliminarMatricula(@PathVariable Integer idUsuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(idUsuario);
			return new ResponseEntity<Usuario>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

}
