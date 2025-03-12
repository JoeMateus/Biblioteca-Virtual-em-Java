package br.com.fuctura.biblioteca.controllers;
//O ERRO QUE APARECE AQUI É POR CONTA QUE O LIVRODTO nao ta completo.

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
@RequestMapping("Livro")
@CrossOrigin("*")
    public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = LivroService.findById(id);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }
    //localhost:8080/Livro?categoria=1

    @GetMapping
    public ResponseEntity<Livro<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id) {
        List<Livro> list = LivroService.findAll(id);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }
   @PostMapping
    public ResponseEntity <LivroDto>save(@RequestParam(value = "categoria", defaultValue = "0") Integer idcat,
                                         @RequestBody LivroDto livroDto) {
        Livro livro = livroService.save(id_cat,livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
   }
    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@PathVariable Integer id,
                                           @RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                           @RequestBody LivroDto livroDto) {
        livroDto.setId(id);
        Livro livro = livroService.update(id_cat, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{genero}")
    public ResponseEntity<List<LivroDto>> findAllLivrosByGenero(@PathVariable String genero) {
        List<Livro> list = livroService.findAllLivrosByCategoriaName(genero);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));

    }
}

