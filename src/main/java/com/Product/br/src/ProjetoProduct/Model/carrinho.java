package com.Product.br.src.ProjetoProduct.Model;

import com.Product.br.src.ProjetoProduct.Model.produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class carrinho {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany //nessa lista pode ter uma ou mais
    private List<produto> produtos = new ArrayList<>();

    private Number valorTotal;

    public List<produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<produto> produtos) {
        this.produtos = produtos;
    }

    public Number getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Number valorTotal) {
        this.valorTotal = valorTotal;
    }

    // **Método para adicionar produto ao carrinho**
    public void adicionarProduto(produto produto) {
        this.produtos.add(produto); // Adiciona o produto à lista
        this.valorTotal = produto.getPreco();
    }
}
