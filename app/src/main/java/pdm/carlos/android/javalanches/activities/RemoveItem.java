package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pdm.carlos.android.javalanches.R;

public class RemoveItem extends AppCompatActivity {

   int idPedido;
   int idProduto;
   int idMesa;
   int pos;
   TextView itemQuantidade;
   TextView itemDescricao;
   int quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);

        itemQuantidade = (TextView) findViewById(R.id.textViewQauntidadeAtualItem);
        itemDescricao = (TextView) findViewById(R.id.textViewDescriaoItem);

        Intent intent = getIntent();
        idMesa = intent.getIntExtra("ID",0);
        pos = intent.getIntExtra("Pos",0);
        idProduto = intent.getIntExtra("IDproduto",0);
        idPedido = intent.getIntExtra("IDpedido",0);

    }

    protected void onStart(){
        super.onStart();

        quantidade = BancoFake.getInstancia().getQuantidadeProduto(idPedido,pos);

        itemQuantidade.setText(Integer.toString(quantidade));
    }

    public void botaoAumentaQuantidade(View view){
        quantidade++;
        itemQuantidade.setText(Integer.toString(quantidade));
    }

    public void botaoDiminuiQuantidade(View view){
        if(quantidade>0){
            quantidade--;
            itemQuantidade.setText(Integer.toString(quantidade));
        }
    }

    public void atualizaQuantidade(View view){
        BancoFake.getInstancia().setQuantidadeProduto(idPedido,idProduto,quantidade,pos);
        /*Intent intent = new Intent(RemoveItem.this, SelecionaTipoProduto.class);
        intent.putExtra("ID",idMesa);
        startActivity(intent);*/
    }

    public void voltar(View view){
        Intent intent = new Intent(RemoveItem.this, DetalhesPedido.class);
        intent.putExtra("ID",idMesa);
        startActivity(intent);
    }
}