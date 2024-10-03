package br.edu.ifpb.maicon.cinema.controller;

import br.edu.ifpb.maicon.cinema.model.DadosUsuarioDTO;
import br.edu.ifpb.maicon.cinema.model.Usuario;
import br.edu.ifpb.maicon.cinema.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Controller é para no máximo dizer que tá faltando algum dado; Não faz lógica

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired // gera um new por de baixo dos panos
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return this.usuarioService.getUsuarios();
    }

    // path param
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioPorId(@PathVariable("id") Long idUsuario) {
        return this.usuarioService.getUsuarioPorId(idUsuario);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> inserir(@RequestBody @Valid DadosUsuarioDTO usuario){
        Usuario usuarioInserido;
        try {
            usuarioInserido = this.usuarioService.inserir(usuario);
            System.out.println("oi");
            return new ResponseEntity<>(usuarioInserido, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario){
        return this.usuarioService.atualizar(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void apagarUsuario(@PathVariable("id") Long id) {
        this.usuarioService.apagar(id);
    }

}
