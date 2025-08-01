package com.nico.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.nico.api.model.Usuario.Role;

@Data
public class UsuarioDTO {
    @NotBlank(message = "O nome de usuário é obrigatório")
    private String username;

    @NotBlank(message = "O nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    private Role role = Role.RH; // Por padrão, será RH
}
