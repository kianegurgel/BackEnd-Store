package com.Product.br.src.ProjetoProduct.Services;

import com.Product.br.src.ProjetoProduct.Model.produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // onde fica metodos
public class produtoServices {

    @Autowired
    private produtoRespository produtoRespository;

    public produto criarProduto(produto produto){
        return produtoRespository.save(produto);
    }
    public produto atualizarProduto(int id, int quantidade){
        Optional<produto> produtoExistente = produtoRespository.findById(id);

        if(produtoExistente.isPresent()){
            produto produto = produtoExistente.get();

            produto.setQuantidade(produto.getQuantidade()+quantidade);

            return produtoRespository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
}

}


