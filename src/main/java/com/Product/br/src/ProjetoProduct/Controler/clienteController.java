package com.Product.br.src.ProjetoProduct.Controler;


import com.Product.br.src.ProjetoProduct.Model.cliente;
import com.Product.br.src.ProjetoProduct.Model.produto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Product.br.src.ProjetoProduct.Services.clienteService;

import java.util.Optional;


@RequestMapping ("/api/cliente")
@Tag(name = "Cliente", description = "Gerenciamento de Cliente")
@RestController
public class clienteController {

    @Autowired
    private clienteService clienteService;


    @PostMapping ("/criarCliente")
     public ResponseEntity<cliente> criarCliente(@RequestBody cliente cliente) {
        cliente novoCliente = clienteService.criarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
//aqui
@PostMapping("/login")

public ResponseEntity<String> login(@RequestParam String cpf, @RequestParam String senha) {
    Optional<cliente> usuario = clienteService.autenticar(cpf, senha);

    if (usuario.isPresent()) {
        return ResponseEntity.ok("Login bem-sucedido");
    } else {
        return ResponseEntity.status(401).body("CPF ou senha inválidos");
    }
}


}
