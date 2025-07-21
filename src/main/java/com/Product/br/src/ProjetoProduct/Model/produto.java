package com.Product.br.src.ProjetoProduct.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // SERVE PARA DAR PERMISSÃO NO BANCO E DECLARAR COMO ENTIDADE
public class produto {



    // ISSO É ENCAPSULAMENTOO!!!!!!!

    @Id // CHAVE PRIMARIA EX CADA PROF TERÁ SEU CODIGO
    @GeneratedValue(strategy = GenerationType.AUTO) //GERAR VALOR AUTOMATICO - PADRAO  ou GenerationType.AUTO
    private int id; // Chave primária

    private  String nomeProduto;
    private  String categoria;
    private  Number preco;
    private  int quantidade;
    private  String lote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Number getPreco() {
        return preco;
    }

    public void setPreco(Number preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
