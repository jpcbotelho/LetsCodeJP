package br.com.bb.letscode.dto;

import java.math.BigDecimal;

public class ProdutoDto {

    //atributos
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    //construtor
    public ProdutoDto(long id, String nome, String descricao, String preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = new BigDecimal(preco);
    }

    //construtor vazio
    public ProdutoDto() {

    }

    //getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco.toString();
    }

    public void setPreco(String preco) {
        this.preco = new BigDecimal(preco);
    }

}
