package io.github.guimaraes131.produtosapi.controller;

import io.github.guimaraes131.produtosapi.model.Produto;
import io.github.guimaraes131.produtosapi.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        produto.setId(UUID.randomUUID().toString());

        return repository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto get(@PathVariable("id") String id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);

        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> getByNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }
}
