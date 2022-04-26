package pdm.carlos.android.javalanches.classes;

import java.io.Serializable;

public class Prato extends Produto  {
    private int servePessoas;

    public Prato() {}

    public Prato(int id,String nome,String descricao,double preco,String foto,int servePessoas) {
        super(id, nome, descricao, preco, foto);
        this.servePessoas=servePessoas;
    }

    public int getServePessoas(){
        return servePessoas;
    }

    public void setServePessoas(int servePessoas){
        this.servePessoas=servePessoas;
    }
}