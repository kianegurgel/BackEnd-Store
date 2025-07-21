package com.Product.br.src.ProjetoProduct.Controler;


import com.Product.br.src.ProjetoProduct.Model.cliente;
import com.Product.br.src.ProjetoProduct.Model.produto;
import com.Product.br.src.ProjetoProduct.Services.acaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/acao")
@Tag(name = "Acao", description = "Gerenciamento Acões de venda e compra")
@RestController
public class acaoController {

    @Autowired
    private acaoService acaoService;

    @PutMapping("/vender/{id}")
    public produto venderProduto(@PathVariable int id, @RequestParam String email){
       return acaoService.venderProduto(id, email);
    }

}
