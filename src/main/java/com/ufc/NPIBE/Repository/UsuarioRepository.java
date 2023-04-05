package com.ufc.NPIBE.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ufc.NPIBE.Entity.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario")
@CrossOrigin("http://localhost:5173/")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>, CrudRepository<Usuario,Long> {

  @Query("SELECT u FROM Usuario u WHERE u.email = ?1 and u.password = ?2")
  Usuario findByUser(String email, String password);

  List<Usuario> findByEmail(@Param("email") String email);
}