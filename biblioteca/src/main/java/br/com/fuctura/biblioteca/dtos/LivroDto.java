package br.com.fuctura.biblioteca.dtos;

import br.com.fuctura.biblioteca.enums.TAMANHO;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.models.Livro;

public class LivroDto {

    private Integer Id;
    private String titulo;
    private String autor;
    private String texto;
    private TAMANHO tamanho;
    private Categoria categoria;

    public LivroDto() {
    }


    public LivroDto(Integer id, String titulo, String autor, String texto, TAMANHO tamanho, Categoria categoria) {
        this.Id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.tamanho = tamanho;
        this.categoria = categoria;
    }

    public LivroDto(Livro livro){
        this.Id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.texto = livro.getTexto();
        this.tamanho = livro.getTamanho();
        this.categoria = livro.getCategoria();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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