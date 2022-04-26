package pdm.carlos.android.javalanches.classes;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private boolean pago;
    private Mesa mesa;
    private ArrayList<PedidoItem> pedidoItems;

    public Pedido(){}

    public Pedido(int numero,Mesa mesa){
        super();
        this.numero=numero;
        this.pago=false;
        this.mesa=mesa;
        this.pedidoItems= new ArrayList<PedidoItem>();
    }

    public int getPago(){
        if(this.pago){
            return 1;
        }
        else {
            return 0;
        }
    }

    public double valorItens(){
        double valor=0;
        for (PedidoItem e: pedidoItems){
            valor += e.getProdutoValor()*e.getQuantidade();
        }
        return valor;
    }

    public void removePedidoItem(int indexProduto){
        this.pedidoItems.remove(indexProduto);
    }

    public void setPago(){
        this.pago=true;
    }

    public int getMesaId(){
        return this.mesa.getCodigo();
    }

    public int getPedidoId(){
        return this.numero;
    }

    public int getQuantidade(int idProduto){
        return this.pedidoItems.get(idProduto).getQuantidade();
    }

    public void setQuantidade(int idProduto,int quantidade){
        for(PedidoItem p: pedidoItems){
            if(p.getCodigoProduto()==idProduto){
                int index = this.pedidoItems.indexOf(p);
                this.pedidoItems.get(index).setQuantidade(quantidade);
            }
        }
    }

    public void adicionaItem(int quantidade, int idProduto){
        boolean achou = false;
        for(PedidoItem p: pedidoItems){
            if(p.getCodigoProduto()==idProduto){
                int index = this.pedidoItems.indexOf(p);
                this.pedidoItems.get(index).addQuantidade(quantidade);
                achou = true;
            }
        }
        if(Boolean.compare(achou,false)==0){
            PedidoItem p1 = new PedidoItem(quantidade,idProduto);
            this.pedidoItems.add(p1);
        }

    }

    public ArrayList<PedidoItem> getPedidoItems(){
        return pedidoItems;
    }
}