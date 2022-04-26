package pdm.carlos.android.javalanches.classes;

import java.io.Serializable;

public class Bebida extends Produto {
    private String embalagem;

    public Bebida() {
        super();
    }

    public Bebida(int id, String nome, String descricao, double preco, String foto, String embalagem) {
        super(id, nome, descricao, preco, foto);
        this.embalagem = embalagem;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

}