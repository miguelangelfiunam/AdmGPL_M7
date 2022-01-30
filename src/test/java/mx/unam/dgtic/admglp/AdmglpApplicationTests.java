package mx.unam.dgtic.admglp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.unam.dgtic.admglp.dao.Usuario;
import mx.unam.dgtic.admglp.repository.UsuarioRepository;

@SpringBootTest
class AdmglpApplicationTests {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	void buscarTodosTest() {
		System.out.println("============== findAll ==============");
		Iterable<Usuario> iterable = usuarioRepository.findAll();
		List<Usuario> milista = new ArrayList<Usuario>();

		iterable.forEach(milista::add);
		iterable.forEach(System.out::println);

		assertThat(milista.size(), greaterThan(6));
	}
}
