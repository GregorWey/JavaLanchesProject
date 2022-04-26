package pdm.carlos.android.javalanches.activities;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.classes.Bebida;
import pdm.carlos.android.javalanches.classes.Mesa;
import pdm.carlos.android.javalanches.classes.Pedido;
import pdm.carlos.android.javalanches.classes.PedidoItem;
import pdm.carlos.android.javalanches.classes.Prato;
import pdm.carlos.android.javalanches.classes.Produto;

public class BancoFake {

    //projeto com finalidade educacional

    private static BancoFake instancia;

    public ArrayList<Mesa> listaMesa;
    public ArrayList<Produto> listaProduto;
    public ArrayList<Pedido> listaPedido;

    public int numeroPedido;
    int idElemento;

    private BancoFake(){
        criaListas();
        criaDadosMesa();
        criaDadosPrudto();
        numeroPedido=0;
    }

    public static BancoFake getInstancia(){
        if(instancia==null){
            instancia = new BancoFake();
        }
        return instancia;
    }

    public ArrayList<Mesa> getListaMesa() {
        return listaMesa;
    }

    public void setListaMesa(ArrayList<Mesa> listaMesa) {
        this.listaMesa = listaMesa;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public ArrayList<Prato> getListaProdutoPrato(){
        ArrayList<Prato> listaPrato = new ArrayList<Prato>();
        for (Produto p: listaProduto){
            if(p instanceof Prato){
                listaPrato.add((Prato)p);
            }
        }
        return listaPrato;
    }

    public ArrayList<Bebida> getListaProdutoBebida(){
        ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();
        for (Produto p: listaProduto){
            if(p instanceof Bebida){
                listaBebida.add((Bebida)p);
            }
        }
        return listaBebida;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ArrayList<Pedido> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(ArrayList<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void pagaPedido(int idPedido, int idMesa){
        this.listaPedido.get(idPedido).setPago();
        this.listaMesa.get(idMesa).setOcupado(false);
    }

    public int criaPedido(int idMesa){
        this.listaMesa.get(idMesa).setOcupado(true);
        Mesa m = this.listaMesa.get(idMesa);
        Pedido p = new Pedido(numeroPedido,m);
        this.listaPedido.add(p);
        numeroPedido++;
        return p.getPedidoId();
    }

    public int getPedidoId(int idMesa){
        for (Pedido e: listaPedido){
            if((Integer.compare(e.getMesaId(),idMesa)==0) && (Integer.compare(e.getPago(),0)==0)){
                idElemento = listaPedido.indexOf(e);
            }
        }
        return idElemento;
    }

    public double calcularTotal(int idPedido){
        double valor;
        valor = this.listaPedido.get(idPedido).valorItens();
        return valor;
    }

    public int getQuantidadeProduto(int idPedido,int idProduto){
        return this.listaPedido.get(idPedido).getQuantidade(idProduto);
    }

    public void setQuantidadeProduto(int idPedido, int idProduto, int quantidade, int indexProduto){
        if(quantidade>0){
            this.listaPedido.get(idPedido).setQuantidade(idProduto,quantidade);
        }
        else{
            this.listaPedido.get(idPedido).removePedidoItem(indexProduto);
        }
    }

    public Pedido getPedido(int idPedido){
        return this.listaPedido.get(idPedido);
    }

    public void deletePedido(int idPedido,int idMesa){
        this.listaPedido.get(idPedido).setPago();
        this.listaMesa.get(idMesa).setOcupado(false);
    }

    public ArrayList<PedidoItem> getItensPedido(int idPedido){
        return this.listaPedido.get(idPedido).getPedidoItems();
    }


    public void adicionaItemPedido(int idPedido,int quantidade,int idProduto){
        this.listaPedido.get(idPedido).adicionaItem(quantidade,idProduto);
    }

    public void criaListas(){
        listaMesa = new ArrayList<Mesa>();
        listaPedido = new ArrayList<Pedido>();
        listaProduto = new ArrayList<Produto>();

    }

    public void criaDadosMesa(){
        int cont = 0;
        Mesa m;

        //cria mesas
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
        m = new Mesa(cont++);
        this.listaMesa.add(m);
    }

    public void criaDadosPrudto(){
        int cont = 0;
        Bebida b;
        Prato p;

        //cria bebidas
        b = new Bebida(cont++,"Coca Cola","Refrigerante",3.50,"@drawable/coca_cola_lata","Lata 350ml");
        this.listaProduto.add(b);

        b = new Bebida(cont++,"Guarana Charrua","Refrigerante",6.00,"@drawable/guarana_charrua_litro","Garrafa 2L");
        this.listaProduto.add(b);

        b = new Bebida(cont++,"Guarana Fruki","Refrigerante",7.00,"@drawable/guarana_fruki_litro","Garrafa 2L");
        this.listaProduto.add(b);

        b = new Bebida(cont++,"Fanta Uva","Refrigerante",8.00,"@drawable/fanta_uva_litro","Garrafa 2L");
        this.listaProduto.add(b);

        b = new Bebida(cont++,"Fanta Laranja ","Refrigerante",8.00,"@drawable/fanta_laranja_litro","Garrafa 2L");
        this.listaProduto.add(b);

        b = new Bebida(cont++,"Coca Cola","Refrigerante",10.00,"@drawable/coca_cola_litro","Garrafa 2L");
        this.listaProduto.add(b);

        b = new Bebida(cont++,"Pepsi","Refrigerante",9.00,"@drawable/pepsi_litro","Garrafa 2L");
        this.listaProduto.add(b);

        //cria comidas
        p = new Prato(cont++,"Pizza de Calabresa","Pizza com queijo e calabresa",22.50,"@drawable/pizza_calabresa",2);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Camarão", "Pizza com queijo e camarão", 30.00,"@drawable/pizza_camarao", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Filé", "Pizza com queijo e carne bovina ao molho", 40.00, "@drawable/pizza_file", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Filé com Batata Palha","Pizza com queijo, carne bovina ao molho e batata palha", 45.00, "@drawable/pizza_file_com_palha", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Picanha ao Alho e Óleo", "Pizza com queijo e picanha ao alho e óleo", 45.00, "@drawable/pizza_picanha_alho_oleo", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Strogonoff de Carne", "Pizza com queijo e carne bonina ao molho de strogonoff com champignon", 40.00, "@drawable/pizza_strogonoff_carne", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Alho e Óleo", "Pizza com queijo, alho frito, catupiry, parmesão e salsa", 35.00,"@drawable/pizza_alho_oleo", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Aspargos", "Pizza com queijo, aspargos, tomate picado e salsa", 30.00, "@drawable/pizza_aspargos", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++,"Pizza de Coração","Pizza com queijo e coração de frango",26.50,"@drawable/pizza_coracao",2);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Brócolis", "Pizza com queijo, brócolis e catupiry", 35.00, "@drawable/pizza_brocolis", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza Mafiosa", "Pizza com queijo, gorgonzola, catupiry e cebola", 35.00, "@drawable/pizza_mafiosa", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza Marguerita", "Pizza com queijo, tomate, manjericão, catupiry e parmesão", 35.00, "@drawable/pizza_marguerita",4);
        this.listaProduto.add(p);

        p = new Prato(cont++, "Pizza de Milho", "Pizza com queijo e milho", 30.00, "@drawable/pizza_milho", 4);
        this.listaProduto.add(p);

        p = new Prato(cont++,"Pizza de Chocolate Preto","Pizza com chocolate preto",23.00,"@drawable/pizza_chocolate_preto",2);
        this.listaProduto.add(p);

        p = new Prato(cont++,"Pizza de Chocolate Branco","Pizza com chocolate branco",23.00,"@drawable/pizza_chocolate_branco",2);
        this.listaProduto.add(p);

        p = new Prato(cont++,"Hamburguer Simples","Hamburguer com tomate, alface, queijo e uma fatia de carne",20.50,"@drawable/hamburger_simples",1);
        this.listaProduto.add(p);

        p = new Prato(cont++,"Hamburguer Duplo","Hamburguer com tomate, alface, queijo e duas fatias de carne",26.50,"@drawable/hamburger_duplo",1);
        this.listaProduto.add(p);
    }
}
