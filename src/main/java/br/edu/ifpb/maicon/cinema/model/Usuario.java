package br.edu.ifpb.maicon.cinema.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public Usuario(DadosUsuarioDTO dto) {
        this.nome = dto.nome();
        this.login = dto.login();
        this.senha = dto.senha();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}