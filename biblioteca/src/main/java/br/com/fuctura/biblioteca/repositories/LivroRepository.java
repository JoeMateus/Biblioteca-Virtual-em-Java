package br.com.fuctura.biblioteca.repositories;

import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer>   {
@Query(value = "SELECT obj FROM Livro as obj WHERE obj.categoria.id =:id_cat")
    List<Livro> findAllLivrosByCategoria(@Param(value = "id_cat")Integer id_cat);

    List<Livro> findByCategoriaGeneroContainingIgnoreCase(String genero);


    // public Optional<Livro> findById( Integer id);
    // public Optional<Livro>findByIdContainingIgnoreCase(Integer Id);
}
