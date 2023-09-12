package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.UsuarioModel;
import com.catalisa.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepository;

  public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
    return usuarioRepository.save(usuarioModel);
  }

  public List<UsuarioModel> listarUsuarios() {
    return usuarioRepository.findAll();
  }

  public Optional<UsuarioModel> buscaPorNome(String nome) {
    Optional<UsuarioModel> usuarioModels = usuarioRepository.findByUsername(nome);
    return usuarioModels;
  }

  public void deletar(Long id) {
    usuarioRepository.deleteById(id);
  }
}
