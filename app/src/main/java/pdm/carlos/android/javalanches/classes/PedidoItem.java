package pdm.carlos.android.javalanches.classes;

import pdm.carlos.android.javalanches.activities.BancoFake;

public class PedidoItem {
    private int quantidade;
    private Produto produto;
    private String foto;

    public PedidoItem(){}

    public PedidoItem(int quantidade){
        super();
        this.quantidade=quantidade;
        this.produto = new Produto();
        this.foto = produto.getFoto();
    }

    public PedidoItem(int quantidade, int idProduto){
        super();
        this.quantidade=quantidade;
        this.produto = BancoFake.getInstancia().listaProduto.get(idProduto);
    }
    public int getCodigoProduto(){
        return this.produto.getId();
    }

    public void setQuantidade(int quant){
        this.quantidade=quant;
    }

    public void addQuantidade(int quant){
        this.quantidade+=quant;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getProdutoValor(){
        return this.produto.getPreco();
    }

    public String getProdutoNome(){
        return this.produto.getNome();
    }

    public String getFoto(){
        return this.produto.getFoto();
    }
}