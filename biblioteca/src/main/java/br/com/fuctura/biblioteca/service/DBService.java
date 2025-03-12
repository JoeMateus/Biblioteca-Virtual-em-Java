package br.com.fuctura.biblioteca.service;

import br.com.fuctura.biblioteca.enums.TAMANHO;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import br.com.fuctura.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class DBService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void instanciaDB() {

        Categoria cat1 = new Categoria(null, "Infórmatica", "Livros de infórmatica");
        Categoria cat2 = new Categoria(null, "Ficção científica", "Livros de ficção científica");
        Categoria cat3 = new Categoria(null, "Biografia", "Livros de biografias");

        Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", TAMANHO.MEDIO, cat1);
        Livro l2 = new Livro(null, "Engenharia do software", "Louis V. Gerstner", "Lorem ipsum", TAMANHO.GRANDE, cat1);
        Livro l3 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", TAMANHO.PEQUENO, cat2);
        Livro l4 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", TAMANHO.MEDIO, cat2);
        Livro l5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", TAMANHO.GRANDE, cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll((Arrays.asList(l1, l2, l3, l4, l5)));

    }


}
