package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.adapters.BebidaAdapter;
import pdm.carlos.android.javalanches.classes.Bebida;
import pdm.carlos.android.javalanches.classes.Prato;

public class ListaBebidas extends AppCompatActivity {

    int idMesa;
    int idPedido;
    ListView lista;
    ArrayList<Bebida> listaBebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bebidas);

        lista = (ListView) findViewById(R.id.listViewBebidas);

        Intent intentPedido= getIntent();
        idMesa = intentPedido.getIntExtra("ID",0);
        idPedido = intentPedido.getIntExtra("IDpedido",0);
    }

    protected void onStart(){
        super.onStart();

        listaBebida = BancoFake.getInstancia().getListaProdutoBebida();

        BebidaAdapter adapter = new BebidaAdapter(this,listaBebida);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaBebidas.this, QuantidadeItem.class);
                intent.putExtra("IDproduto",listaBebida.get(position).getId());
                intent.putExtra("IDmesa",idMesa);
                intent.putExtra("IDpedido",idPedido);
                startActivity(intent);
            }
        });
    }
}