package com.Product.br.src.ProjetoProduct.Controler;

import com.Product.br.src.ProjetoProduct.Model.carrinho;
import com.Product.br.src.ProjetoProduct.Model.produto;
import com.Product.br.src.ProjetoProduct.Services.carrinhoRespository;
import com.Product.br.src.ProjetoProduct.Services.produtoRespository;
import com.Product.br.src.ProjetoProduct.Services.produtoServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //  controler do tipo rest - API
@Tag(name = "Produto", description = "Gerenciamento de Produto")  //swag
@RequestMapping("/api/produto") // SEMPRE anotation ficar colado com o metodo da classe (ESSE CONTROLLER SERÁ EXPOSTO P/ SER CONSUMIDO )
public class produtoController {

    @Autowired
    private produtoServices produtoServices;

    @PostMapping("/criarproduto")
    public ResponseEntity<produto> criarProduto(@RequestBody produto produto) {
        produto novoProduto = produtoServices.criarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);

    }

    @PutMapping("/atualizarProduto/{id}")
    public produto atualizarProduto(@PathVariable int id, @RequestParam int quantidade) {
        return produtoServices.atualizarProduto(id,quantidade);

    }

    @Autowired
    private carrinhoRespository carrinhoRepository;

    @Autowired
    private produtoRespository produtoRepository;

    @PostMapping("/adicionar/{idProduto}")
    public carrinho adicionarProdutoAoCarrinho(@PathVariable int idProduto) {
        produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        carrinho carrinho = carrinhoRepository.findById(1L)
                .orElseGet(() -> {
                    carrinho novoCarrinho = new carrinho();
                    carrinhoRepository.save(novoCarrinho);
                    return novoCarrinho;
                });

        carrinho.adicionarProduto(produto);
        return carrinhoRepository.save(carrinho);
    }
}





