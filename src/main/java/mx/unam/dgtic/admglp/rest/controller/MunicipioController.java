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

import mx.unam.dgtic.admglp.dao.Municipio;
import mx.unam.dgtic.admglp.repository.MunicipioRepository;

@RestController
@RequestMapping("/mun")
public class MunicipioController {

	@Autowired
	private MunicipioRepository municipioRepository;

	@GetMapping
	public Iterable<Municipio> findAll(@RequestParam Map<String, String> parametros) {
		Iterable<Municipio> municipios = null;
		int leidos = 0;
		if (leidos == 0) {
			municipios = municipioRepository.findAll();
		}
		return municipios;
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<Municipio> buscarMunicipio(@PathVariable Integer idUsuario) {
		Optional<Municipio> optional = municipioRepository.findById(idUsuario);
		if (optional.isPresent()) {
			Municipio m = optional.get();
			return new ResponseEntity<Municipio>(m, HttpStatus.OK);
		} else {
			return new ResponseEntity<Municipio>(HttpStatus.NOT_FOUND);
		}
	}

}
