package com.joaobatista.produtoapi.resources;

import com.joaobatista.produtoapi.domain.Produto;
import com.joaobatista.produtoapi.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST PRODUTOS")
@CrossOrigin (origins= "*")
public class ProdutoResources {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation("Retorna a lista de produtos cadastrados.")
    public List<Produto> listaprodutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation("Retorna a lista de produtos cadastrados de acodo com o id informado.")
    public Produto listaprodutosunico(@PathVariable(value = "id")long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produtos")
    @ApiOperation("Cria um novo cadastro de produto")
    public Produto createproduto (@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos")
    @ApiOperation("Deleta um produto do banco de dados")
    public void deleteproduto (@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @DeleteMapping("/produtos/{id}")
    @ApiOperation("Deleta um produto do banco de dados de acordo com id informado")
    public void deleteprodutoid (@PathVariable(value = "id")long id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/produtos")
    @ApiOperation("Atualiza o cadastro de um produto")
    public void atualizaproduto (@RequestBody Produto produto){
        produtoRepository.save(produto);
    }
}
