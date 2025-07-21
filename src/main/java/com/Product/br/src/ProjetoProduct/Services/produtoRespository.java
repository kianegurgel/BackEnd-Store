package com.Product.br.src.ProjetoProduct.Services;

import com.Product.br.src.ProjetoProduct.Model.produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface produtoRespository extends JpaRepository<produto, Integer> {
 // Optional<produto> findByCpf( int id);  // é opcional pode ou n ser usado. findBycpf é um metodo do java que procura algo por uma variavel
}
