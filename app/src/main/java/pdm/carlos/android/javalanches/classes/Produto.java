package pdm.carlos.android.javalanches.classes;

import java.io.Serializable;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String foto;

    public Produto() {}

    public Produto(int id, String nome, String descricao, double preco, String foto){
        super();
        this.nome=nome;
        this.descricao=descricao;
        this.preco=preco;
        this.foto=foto;
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getFoto(){
        return foto;
    }

    public double getPreco(){
        return preco;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setFoto(String foto){
        this.foto=foto;
    }

    public void setDescricao(String descricao){
        this.descricao=descricao;
    }

    public void setPreco(double preco){
        this.preco=preco;
    }

    public void setId(int id){
        this.id=id;
    }

}