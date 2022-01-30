package mx.unam.dgtic.admglp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.unam.dgtic.admglp.dao.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

	public List<Usuario> findByApodo(String apodo);

	public List<Usuario> findByEdadGreaterThanEqual(Integer edad);

	public List<Usuario> findByEdadBetween(Integer edadInicio, Integer edadFin);

	public List<Usuario> findByNombre(String nombre);

	public List<Usuario> findByApellido1(String apellido1);

	public List<Usuario> findByApellido2(String apellido2);

	public List<Usuario> findByNombreOrApellido1(String nombre, String apellido1);

	public List<Usuario> findByNombreOrApellido2(String nombre, String apellido2);

	public List<Usuario> findByApellido1OrApellido2(String apellido1, String apellido2);
	
	public List<Usuario> findByNombreAndApellido1AndApellido2(String nombre, String apellido1, String apellido2);

}
