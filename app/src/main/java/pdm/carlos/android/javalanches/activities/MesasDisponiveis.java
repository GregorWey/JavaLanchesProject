package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.adapters.MesaComPedidoAdapter;
import pdm.carlos.android.javalanches.adapters.MesaVaziaAdapter;
import pdm.carlos.android.javalanches.classes.Mesa;

public class MesasDisponiveis extends AppCompatActivity {

    ListView lista;
    ArrayList<Mesa> listaMesa;
    ArrayList<Mesa> listaMesaVazia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaMesaVazia = new ArrayList<Mesa>();
        setContentView(R.layout.activity_mesas_disponiveis);
        lista = (ListView) findViewById(R.id.listViewMesasSemPedidos);
    }

    protected void onStart(){
        super.onStart();

        listaMesa = BancoFake.getInstancia().getListaMesa();

        for(Mesa m: listaMesa){
            if(Boolean.compare(m.isOcupado(),false)==0){
                listaMesaVazia.add(m);
            }
        }

        MesaVaziaAdapter adapter = new MesaVaziaAdapter(this,listaMesaVazia);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idPedido = BancoFake.getInstancia().criaPedido(listaMesaVazia.get(position).getCodigo());
                Intent intent = new Intent(MesasDisponiveis.this, SelecionaTipoProduto.class);
                intent.putExtra("ID",listaMesaVazia.get(position).getCodigo());
                intent.putExtra("IDpedido",idPedido);
                startActivity(intent);
            }
        });
    }

    public void botaoVoltarPedidos(View view){
        Intent intent = new Intent(MesasDisponiveis.this, MainActivity.class);
        startActivity(intent);
    }
}