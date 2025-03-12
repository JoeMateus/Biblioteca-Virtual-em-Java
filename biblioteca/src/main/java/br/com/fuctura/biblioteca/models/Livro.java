package br.com.fuctura.biblioteca.models;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.enums.TAMANHO;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private String texto;

    private TAMANHO tamanho;


    @ManyToMany
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Livro(){
    }
    public Livro( Integer id, String titulo, String autor, String texto, TAMANHO tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.tamanho = tamanho;
        this.categoria = categoria;
      }

    public Livro(LivroDto livroDto) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TAMANHO getTamanho() {
        return tamanho;
    }

    public void setTamanho(TAMANHO tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}





