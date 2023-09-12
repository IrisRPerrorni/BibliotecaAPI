package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/livros") // caminho da requisição
public class LivrosController {  //classe de validação

    @Autowired
    LivrosService livrosService; //implementando a classe Livro service

    //Endpoints de exibir os livros
    //Requisição Get - pega todos os livros do banco
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public List<LivrosModel>exibeTodosLivros(){
        return livrosService.exibirTodos();
    }

    //Endpoint de exibir somente um livro especifico
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/livros/{id}")   // caminho do id pedido , o pathvariavel é para basicamente fazer o papel de set
    public Optional <LivrosModel>exibirLivroPorId(@PathVariable Long id){ //optional vai pegar uma lista e procurar dentro da lista uma informação
        return livrosService.exibirPorId(id);
    }

    //Endpoints de inserção
    //Requisição POST - Insere algum dado dentro do banco

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED) //Responder ao usuario com um status
    @PostMapping
    public LivrosModel cadastrarNovoLivro(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }

    //Endpoin de alteração
    //Requisição PUT - altera algum dado dentro do banco

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/livros/{id}")
    public LivrosModel alterarLivro(@PathVariable Long id , @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id,livrosModel);
    }

    //Endpoint de deleção
    //Requisição DELETE - deleta algum dado dentro do banco

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping (path = "/livros/{id}")
    public void deletarLivro(@PathVariable Long id){
        livrosService.deletar(id);
    }
}
