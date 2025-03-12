package br.com.fuctura.biblioteca.service;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.excepentions.ObjectNotFoundException;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import br.com.fuctura.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private static LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public static Livro findById(Integer id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return livro.get();
        }
        throw new ObjectNotFoundException("Livro não Encontrada");
        //return cat.orElseThrow(() -> new ObjectNotFoundException("Categoria não Encontrada"));
    }
    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivrosByCategoria(id_cat);

    }
    public Livro save (Integer idCat, LivroDto livroDto) {
        livroDto.setId(null);
        Categoria cat = categoriaService.findById(idCat);
        livroDto.setCategoria(cat);
        return livroRepository.save(new Livro(livroDto));
    }

    public Livro update(Integer idCat, LivroDto livroDto) {

        findById(livroDto.getId());
        Categoria oldCategoria = categoriaService.findById(idCat);
        livroDto.setCategoria(oldCategoria);

        //Livro livro = new Livro(livroDto);

        return livroRepository.save(new Livro(livroDto));
    }

    public void delete (Integer id){
    findById(id);
    livroRepository.deleteById(id);

        }
    public List<Livro> findAllLivrosByCategoriaName(String genero) {
        categoriaService.findByGenero(genero);
        return livroRepository.findByCategoriaGeneroContainingIgnoreCase(genero);
    }
}


