package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivrosService {
    //A anotação “@Autowired” pode ligar automaticamente o bean em um construtor,
    // método setter, propriedade ou métodos com vários parâmetros.
    // Ao usar a anotação @Autowired em métodos setter, você pode eliminar
    // a tag <property> no arquivo de configuração XML.
    @Autowired
    LivrosRepository livrosRepository; // implementar a interface

    //Método que exibe todos os livros;

    public List<LivrosModel>exibirTodos(){

        return livrosRepository.findAll(); // ele irá exibir todos os livros cadastrados
    }

    //Metodo que exibe somente o livro especifico
    public Optional<LivrosModel>exibirPorId(Long id){

        return livrosRepository.findById(id);
    }
    //metodo de cadastro de um novo livro
    public LivrosModel cadastrar(LivrosModel livrosModel){

        return livrosRepository.save(livrosModel);  //salvar o livro no corpo da requisição
    }

    //Método que altera um livro já existente

    public LivrosModel alterar(Long id , LivrosModel livrosModel){
        LivrosModel livros = exibirPorId(id).get();

        if (livrosModel.getNome() != null){
            livros.setNome(livrosModel.getNome());
        }
        if (livrosModel.getAutor() != null){
            livros.setAutor(livrosModel.getAutor());
        }
        if (livrosModel.getDataDeLancamento() != null){
            livros.setDataDeLancamento(livrosModel.getDataDeLancamento());
        }
        if (livrosModel.getCodigoDoLivro() != null){
            livros.setCodigoDoLivro(livrosModel.getCodigoDoLivro());
        }
        return livrosRepository.save(livros);
    }
    //Metodo que deleta um livro já existente
    public void deletar(Long id){

        livrosRepository.deleteById(id);
    }

}
