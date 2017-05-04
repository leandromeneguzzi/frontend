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
public class Negocio {

    private Integer id;
    private String tipo;
    private String telefone;
    private String nome;
    private Integer id_mercadoria;

    public Negocio(Integer id, String tipo, String telefone, String nome, Integer id_mercadoria) {
        this.id = id;
        this.tipo = tipo;
        this.telefone = telefone;
        this.nome = nome;
        this.id_mercadoria = id_mercadoria;
    }

    public Negocio(String tipo, String telefone, String nome, Integer id_mercadoria) {
        this.tipo = tipo;
        this.telefone = telefone;
        this.nome = nome;
        this.id_mercadoria = id_mercadoria;
    }

    public Negocio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId_mercadoria() {
        return id_mercadoria;
    }

    public void setId_mercadoria(Integer id_mercadoria) {
        this.id_mercadoria = id_mercadoria;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
