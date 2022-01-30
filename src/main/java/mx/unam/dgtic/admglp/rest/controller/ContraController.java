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

import mx.unam.dgtic.admglp.dao.Contra;
import mx.unam.dgtic.admglp.repository.ContraRepository;

@RestController
@RequestMapping("/contra")
public class ContraController {

	@Autowired
	private ContraRepository contraRepository;

	@GetMapping
	public Iterable<Contra> findAll(@RequestParam Map<String, String> parametros) {
		Iterable<Contra> contras = null;
		int leidos = 0;
		if (leidos == 0) {
			contras = contraRepository.findAll();
		}
		return contras;
	}
	
	@GetMapping("/{idContra}")
	public ResponseEntity<Contra> buscarContra(@PathVariable Integer idContra) {
		Optional<Contra> optional = contraRepository.findById(idContra);
		if (optional.isPresent()) {
			Contra c = optional.get();
			return new ResponseEntity<Contra>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<Contra>(HttpStatus.NOT_FOUND);
		}
	}

}
