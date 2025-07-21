package com.Product.br.src.ProjetoProduct.Services;

import com.Product.br.src.ProjetoProduct.Model.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Product.br.src.ProjetoProduct.Model.cliente;

import java.util.Optional;

@Service
public class clienteService {

    @Autowired
    private clienteRespository clienteRespository;

    public cliente criarCliente (cliente cliente) {
        return clienteRespository.save(cliente);

    }

    public Optional<cliente> autenticar(String cpf, String senha){
      Optional<cliente> cliente = clienteRespository.findByCpf(cpf);
      if(cliente.isPresent() && cliente.get().getSenha().equals(senha)){
          return cliente;
      }
        return Optional.empty();


    }








}
