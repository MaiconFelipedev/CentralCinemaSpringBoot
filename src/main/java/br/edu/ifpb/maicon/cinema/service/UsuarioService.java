package br.edu.ifpb.maicon.cinema.service;

import br.edu.ifpb.maicon.cinema.controller.repositories.UsuarioRepository;
import br.edu.ifpb.maicon.cinema.model.DadosUsuarioDTO;
import br.edu.ifpb.maicon.cinema.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Inteligência é no service -> if

@Service
// Qualquer exceção no RunTime irá dar Roolback
@Transactional // Commit | Roolback -> Salvar, inserir; Ao fazer RunTime desfaz tudo
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Não é transactional
    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll(); // me devolva todos os usuários
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        // retorna um opcional, não vai dar NullPointerException
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    public Usuario inserir(DadosUsuarioDTO usuarioAInserir) {
        Usuario usuarioInserido = new Usuario(usuarioAInserir);
        this.usuarioRepository.save(usuarioInserido);
        return usuarioInserido;
    }

    public Usuario atualizar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public void apagar(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}