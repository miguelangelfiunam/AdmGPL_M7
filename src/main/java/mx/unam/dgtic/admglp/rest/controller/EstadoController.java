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

import mx.unam.dgtic.admglp.dao.Estado;
import mx.unam.dgtic.admglp.repository.EstadoRepository;

@RestController
@RequestMapping("/edo")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public Iterable<Estado> buscarTodos(@RequestParam Map<String, String> parametros) {
		Iterable<Estado> estados = null;
		int leidos = 0;
		if (leidos == 0) {
			estados = estadoRepository.findAll();
		}
		return estados;
	}
	
	@GetMapping("/{idEstado}")
	public ResponseEntity<Estado> buscarEstado(@PathVariable Integer idEstado) {
		Optional<Estado> optional = estadoRepository.findById(idEstado);
		if (optional.isPresent()) {
			Estado e = optional.get();
			return new ResponseEntity<Estado>(e, HttpStatus.OK);
		} else {
			return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
		}
	}

}
