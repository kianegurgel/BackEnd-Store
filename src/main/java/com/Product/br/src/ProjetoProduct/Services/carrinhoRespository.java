package com.Product.br.src.ProjetoProduct.Services;

import com.Product.br.src.ProjetoProduct.Model.carrinho;
import com.Product.br.src.ProjetoProduct.Model.produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carrinhoRespository extends JpaRepository<carrinho, Long>{
    }

