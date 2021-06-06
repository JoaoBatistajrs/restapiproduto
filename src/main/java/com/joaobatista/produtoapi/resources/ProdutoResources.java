package com.joaobatista.produtoapi.resources;

import com.joaobatista.produtoapi.domain.Produto;
import com.joaobatista.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResources {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaprodutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Produto listaprodutosunico(@PathVariable(value = "id")long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produtos")
    public Produto createproduto (@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos")
    public void deleteproduto (@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public void deleteprodutoid (@PathVariable(value = "id")long id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/produtos")
    public void atualizaproduto (@RequestBody Produto produto){
        produtoRepository.save(produto);
    }
}
