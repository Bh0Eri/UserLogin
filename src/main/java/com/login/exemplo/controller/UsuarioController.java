package com.login.exemplo.controller;

import com.login.exemplo.entity.Usuario;
import com.login.exemplo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping(value = "Usuario/Cadastro")
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario user){
        Usuario usuario = new Usuario(user.getNome(), user.getEmail(), user.getSenha());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);

    }
    @PostMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody Usuario user){
        Usuario findUser = usuarioRepository.findByEmail(user.getEmail());

        if(findUser == null){
            return ResponseEntity.ok("Usuario não encontrado");
        }else {
         if (findUser.getSenha().equals(user.getSenha())) {
             return ResponseEntity.ok("Login com Sucesso");
         }else {
             return ResponseEntity.ok("Senha Incorreto");
         }
        }
    }
    @GetMapping(value = "fiama")
    public List<Usuario> listaUsuarios1(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
    @GetMapping(value = "produto/{id}")
    public Usuario usuarioPorId(@PathVariable int id){
        return usuarioRepository.findById(id).get();
    }
    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){

        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Excluido com sucesso!");
    }
    @PutMapping("Update/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable int id, @RequestBody Usuario user){
        Optional<Usuario> antigo = usuarioRepository.findById(id);
        if(antigo.isPresent()){
            Usuario u = antigo.get();
            u.setNome(user.getNome());
            u.setEmail(user.getEmail());
            u.setSenha(user.getSenha());
            usuarioRepository.save(u);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}