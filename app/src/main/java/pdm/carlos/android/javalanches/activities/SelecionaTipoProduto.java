package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import pdm.carlos.android.javalanches.R;

public class SelecionaTipoProduto extends AppCompatActivity {

    int idMesa;
    int idPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleciona_tipo_produto);

        Intent intentPedido= getIntent();
        idMesa = intentPedido.getIntExtra("ID",0);
        idPedido = intentPedido.getIntExtra("IDpedido",0);
    }

    protected void onStart(){
        super.onStart();
    }

    public void botaoVoltarMesasLivres(View view){
        BancoFake.getInstancia().deletePedido(idPedido,idMesa);
        Intent intentPedido = new Intent(SelecionaTipoProduto.this, MesasDisponiveis.class);
        startActivity(intentPedido);
    }

    public void botaoBebidas(View view){
        Intent intentPedido = new Intent(SelecionaTipoProduto.this, ListaBebidas.class);
        intentPedido.putExtra("ID",idMesa);
        intentPedido.putExtra("IDpedido",idPedido);
        startActivity(intentPedido);

    }

    public void botaoPratos(View view){
        Intent intentPedido = new Intent(SelecionaTipoProduto.this,ListaPratos.class);
        intentPedido.putExtra("ID",idMesa);
        intentPedido.putExtra("IDpedido",idPedido);
        startActivity(intentPedido);
    }
}