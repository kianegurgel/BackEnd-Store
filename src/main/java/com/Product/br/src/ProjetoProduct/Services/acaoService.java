package com.Product.br.src.ProjetoProduct.Services;

import com.Product.br.src.ProjetoProduct.Model.produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class acaoService {


    @Autowired
    private produtoRespository produtoRespository;

    @Autowired
    private emailService emailService;


    public produto venderProduto(int id, String email){
        Optional<produto> produtoExistente = produtoRespository.findById(id);

        if(produtoExistente.isPresent()){
            produto produto = produtoExistente.get();

            produto.setQuantidade(produto.getQuantidade()-1);

            String mensagem = "Obrigado por sua compra! Seu pedido foi confirmado.";

            // Envio do e-mail dinâmico
            emailService.enviarEmail(email, "Confirmação de Compra", mensagem);

        return produtoRespository.save(produto);

        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }





    }
}
