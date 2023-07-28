package com.catalisa.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_LIVROS") // criando a tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 100, nullable = false)
    private String autor;
    @Column(length = 10, nullable = false)
    private String dataDeLancamento;
    @Column(length = 13, nullable = false)
    private String codigoDoLivro;
}
