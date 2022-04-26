package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.adapters.PedidoItemAdapter;
import pdm.carlos.android.javalanches.classes.PedidoItem;

public class DetalhesPedido extends AppCompatActivity {

    int idMesa;
    int idPedido;
    ListView lista;
    TextView valor;
    ArrayList<PedidoItem> listaPedidoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pedido);

        lista = (ListView) findViewById(R.id.listViewPedidos);
        valor = (TextView) findViewById(R.id.textViewValor);

        Intent intentPedido = getIntent();
        idMesa = intentPedido.getIntExtra("ID",0);
    }

    protected void onStart(){
        super.onStart();

        idPedido=BancoFake.getInstancia().getPedidoId(idMesa);
        listaPedidoItem = BancoFake.getInstancia().getItensPedido(idPedido);
        calcularValor();

        PedidoItemAdapter adapter = new PedidoItemAdapter(this, listaPedidoItem);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //BancoFake.getInstancia().removeItensPedido(idPedido,position);
                Intent intent = new Intent(DetalhesPedido.this,RemoveItem.class);
                intent.putExtra("ID",idMesa);
                intent.putExtra("Pos",position);
                intent.putExtra("IDproduto",listaPedidoItem.get(position).getCodigoProduto());
                intent.putExtra("IDpedido",idPedido);
                startActivity(intent);
            }
        }
        );
    }

    public void calcularValor(){
        double valortotal;
        valortotal = BancoFake.getInstancia().calcularTotal(idPedido);
        valor.setText("R$ "+Double.toString(valortotal) + "0");
    }

    public void botaoVoltar(View view){
        Intent intent = new Intent(DetalhesPedido.this, MainActivity.class);
        startActivity(intent);
    }

    public void botaoAdicionar(View view){
        Intent intent = new Intent(DetalhesPedido.this, SelecionaTipoProduto.class);
        intent.putExtra("ID",idMesa);
        intent.putExtra("IDpedido",idPedido);
        startActivity(intent);
    }

    public void botaoPagar(View view){
        BancoFake.getInstancia().pagaPedido(idPedido,idMesa);
        Intent intent = new Intent(DetalhesPedido.this, MainActivity.class);
        startActivity(intent);
    }
}