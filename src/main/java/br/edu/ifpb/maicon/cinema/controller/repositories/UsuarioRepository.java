package br.edu.ifpb.maicon.cinema.controller.repositories;

import br.edu.ifpb.maicon.cinema.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// repositorio JPA que dá o CRUD pronto
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findByNomeAndLogin(String nome, String login);
}
