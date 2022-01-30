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

import mx.unam.dgtic.admglp.dao.Asentamiento;
import mx.unam.dgtic.admglp.repository.AsentamientoRepository;

@RestController
@RequestMapping("/asen")
public class AsentamientoController {

	@Autowired
	private AsentamientoRepository asentamientoRepository;

	@GetMapping
	public Iterable<Asentamiento> findAll(@RequestParam Map<String, String> parametros) {
		Iterable<Asentamiento> asentamientos = null;
		int leidos = 0;
		if (leidos == 0) {
			asentamientos = asentamientoRepository.findAll();
		}
		return asentamientos;
	}
	
	@GetMapping("/{idAsentamiento}")
	public ResponseEntity<Asentamiento> buscarAsentamiento(@PathVariable Integer idAsentamiento) {
		Optional<Asentamiento> optional = asentamientoRepository.findById(idAsentamiento);
		if (optional.isPresent()) {
			Asentamiento a = optional.get();
			return new ResponseEntity<Asentamiento>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<Asentamiento>(HttpStatus.NOT_FOUND);
		}
	}

}
