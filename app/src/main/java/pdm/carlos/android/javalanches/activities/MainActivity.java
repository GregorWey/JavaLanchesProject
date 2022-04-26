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
import pdm.carlos.android.javalanches.adapters.MesaComPedidoAdapter;
import pdm.carlos.android.javalanches.classes.Mesa;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<Mesa> listaMesa;
    ArrayList<Mesa> listaMesaOcupada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaMesaOcupada = new ArrayList<Mesa>();
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listViewMesasComPedidos);
    }

    protected void onStart(){
        super.onStart();

        listaMesa = BancoFake.getInstancia().getListaMesa();

        for(Mesa m: listaMesa){
            if(Boolean.compare(m.isOcupado(),true)==0){
                listaMesaOcupada.add(m);
            }
        }

        MesaComPedidoAdapter adapter = new MesaComPedidoAdapter(this,listaMesaOcupada);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalhesPedido.class);
                intent.putExtra("ID",listaMesaOcupada.get(position).getCodigo());
                startActivity(intent);
            }
        }
        );
    }

    public void botaoPedido(View view){
        Intent intentPedido = new Intent(MainActivity.this,MesasDisponiveis.class);
        startActivity(intentPedido);
    }
}