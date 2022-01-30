package mx.unam.dgtic.admglp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.unam.dgtic.admglp.dao.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

}
