package com.nico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nico.api.dto.UsuarioDTO;
import com.nico.api.model.Usuario;
import com.nico.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = usuarioService.cadastrar(usuarioDTO);
        return ResponseEntity.ok(novoUsuario);
    }
}
