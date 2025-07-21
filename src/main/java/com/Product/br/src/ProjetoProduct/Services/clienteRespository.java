package com.Product.br.src.ProjetoProduct.Services;

import com.Product.br.src.ProjetoProduct.Model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface clienteRespository extends JpaRepository<cliente, Long> {
    Optional<cliente> findByCpf(String cpf);
}
