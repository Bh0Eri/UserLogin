package com.login.exemplo.controller;


import com.login.exemplo.entity.Produto;
import com.login.exemplo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto/")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;


    @GetMapping("Buscar/{id}")
    public ResponseEntity<?> BuscarId(@PathVariable int id){
       Optional<Produto>  produto = produtoRepository.findById(id);
       if(produto.isPresent()){
           return ResponseEntity.ok().body(produto.get());
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não encontrado!");
       }
    }
    @GetMapping("showAll")
    public ResponseEntity<?> showAll(){
        List<Produto> all = produtoRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("Criar")
    public ResponseEntity<Produto> Criar(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<?> Deletar(@PathVariable int id){
        Optional<Produto>  produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            produtoRepository.delete(produto.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produto.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado!");
    }
}
    @PutMapping("Edit/{id}")
    public ResponseEntity<?> Editar(@PathVariable int id, @RequestBody Produto produto){
        Optional<Produto> refresh = produtoRepository.findById(id);
        if(refresh.isPresent()){
                Produto p = refresh.get();
                p.setQnt(produto.getQnt());
                produtoRepository.save(p);
            return ResponseEntity.ok().body(produto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existe");
        }
    }
    @PutMapping("EditarPreco/{id}")
    public ResponseEntity<?> EditarPreco(@RequestBody Produto produto){
        Optional<Produto> refresh = produtoRepository.findById(produto.getId());
        if(refresh.isPresent()) {
            Produto p = refresh.get();
            p.setPrice(produto.getPrice());
            produtoRepository.save(p);
            return ResponseEntity.ok(refresh);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Inexistente");
        }

    }
}
