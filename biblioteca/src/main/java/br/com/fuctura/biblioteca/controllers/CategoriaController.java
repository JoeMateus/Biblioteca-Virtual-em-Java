package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

//@GetMapping("/{id}") = findById
//@GetMapping = findAll
//@PutMapping("/{id}") = atualizar
//@PostMapping = = salvar
    //@DeleteMapping("/{id}") = deletar

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public Categoria findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return cat; //

    }
    @GetMapping(value = "nome/{genero}")
    public Categoria findBygenero(@PathVariable String genero) {
        Categoria cat = categoriaService.findByGenero(genero);
        return cat;
    }
    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return list;
    }
@PostMapping
public Categoria save(@RequestBody Categoria categoria) {
    Categoria cat = categoriaService.save(categoria);
    return cat;
}

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Integer id ,@RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria cat = categoriaService.update(categoria);
        return cat;
    }
    @PutMapping("nome/{genero}")
    public Categoria update(@PathVariable String genero ,@RequestBody Categoria categoria) {
        categoria.getGenero();
        Categoria cat = categoriaService.update(categoria);
        return cat;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Integer id){
        categoriaService.delete(id);
    }
    @DeleteMapping("/nome/{genero}")
    public void delete(@PathVariable  String genero){
        categoriaService.delete(Integer.valueOf(genero));
}}