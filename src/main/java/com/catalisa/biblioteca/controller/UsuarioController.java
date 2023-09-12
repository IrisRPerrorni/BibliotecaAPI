package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.UsuarioModel;
import com.catalisa.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/usuario")
public class UsuarioController {

  @Autowired
  UsuarioService usuarioService;

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @PostMapping
  public ResponseEntity<UsuarioModel> registrar(@RequestBody UsuarioModel usuarioModel) {
    UsuarioModel usuario = usuarioService.cadastrar(usuarioModel);
    return new ResponseEntity<>(usuario, HttpStatus.CREATED);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping
  public List<UsuarioModel> listarUsuarios() {
    return usuarioService.listarUsuarios();
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping(path= "/usuarioNome")
  public ResponseEntity<Optional<UsuarioModel>> buscarUsuarioNome(@RequestParam String nome) {
    return ResponseEntity.ok(usuarioService.buscaPorNome(nome));
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping
  public void deletar(Long id) {
    usuarioService.deletar(id);
  }
}
