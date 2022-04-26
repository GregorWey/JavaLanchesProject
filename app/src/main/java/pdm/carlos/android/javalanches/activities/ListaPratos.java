package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.adapters.PratoAdapter;
import pdm.carlos.android.javalanches.classes.Prato;

public class ListaPratos extends AppCompatActivity {

    int idMesa;
    int idPedido;
    ListView lista;
    ArrayList<Prato> listaPrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pratos);

        lista = (ListView) findViewById(R.id.listViewPratos);

        Intent intentPedido= getIntent();
        idMesa = intentPedido.getIntExtra("ID",0);
        idPedido = intentPedido.getIntExtra("IDpedido",0);
    }

    protected void onStart(){
        super.onStart();

        listaPrato = BancoFake.getInstancia().getListaProdutoPrato();

        PratoAdapter adapter = new PratoAdapter(this, listaPrato);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaPratos.this, QuantidadeItem.class);
                intent.putExtra("IDproduto",listaPrato.get(position).getId());
                intent.putExtra("IDmesa",idMesa);
                intent.putExtra("IDpedido",idPedido);
                startActivity(intent);
            }
        });

    }
}