package br.edu.ifpb.maicon.cinema.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record DadosUsuarioDTO(@NotEmpty String nome,
                                    @NotEmpty(message = "O login não pode estar vazio.")
                                    @Email(message = "Formato de e-mail inválido.")  // Validação para garantir que o login seja um e-mail
                                     String login,
                                     @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "A senha deve ter no mínimo 8 caracteres e incluir letras e números.")
                                     String senha) {
}
