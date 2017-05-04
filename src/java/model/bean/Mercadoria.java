/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Leandro
 */

public class Mercadoria {
    
    private Integer cod;
    private String tipo;    
    private String nome;
    private Integer quantidade;
    private Double preco;

    public Mercadoria() {
    }

    public Mercadoria(Integer cod, String tipo, String nome, Integer quantidade, Double preco) {
        this.cod = cod;
        this.tipo = tipo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Mercadoria(String tipo, String nome, Integer quantidade, Double preco) {
        this.tipo = tipo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    
    
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    
    
    
}


