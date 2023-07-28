package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class LivrosController {  //classe de validação

    @Autowired
    LivrosService livrosService; //implementando a classe Livro service

    //Endpoints de exibir os livros
    //Requisição Get - pega todos os livros do banco

    @GetMapping (path = "/livros")   // caminho da requisição
    public List<LivrosModel>exibeTodosLivros(){
        return livrosService.exibirTodos();
    }

    //Endpoint de exibir somente um livro especifico

    @GetMapping(path = "/livros/{id}")   // caminho do id pedido , o pathvariavel é para basicamente fazer o papel de set
    public Optional <LivrosModel>exibirLivroPorId(@PathVariable Long id){ //optional vai pegar uma lista e procurar dentro da lista uma informação
        return livrosService.exibirPorId(id);
    }

    //Endpoints de inserção
    //Requisição POST - Insere algum dado dentro do banco

    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED) //Responder ao usuario com um status
    public LivrosModel cadastrarNovoLivro(@RequestBody LivrosModel livrosModel){
        return livrosService.cadastrar(livrosModel);
    }

    //Endpoin de alteração
    //Requisição PUT - altera algum dado dentro do banco

    @PutMapping(path = "/livros/{id}")
    public LivrosModel alterarLivro(@PathVariable Long id , @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id,livrosModel);
    }

    //Endpoint de deleção
    //Requisição DELETE - deleta algum dado dentro do banco

    @DeleteMapping (path = "/livros/{id}")
    public void deletarLivro(@PathVariable Long id){
        livrosService.deletar(id);
    }



}
