package pdm.carlos.android.javalanches.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.classes.Produto;

public class QuantidadeItem extends AppCompatActivity {

    int idMesa;
    int idItem;
    int idPedido;
    int quantidade;
    TextView textoQuantidade;
    TextView textoNome;
    TextView textoDescricao;
    TextView textoPreco;
    ArrayList<Produto> listaProduto;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_item);

        quantidade=0;
        textoQuantidade= (TextView) this.findViewById(R.id.textViewQuant);
        textoNome = (TextView) this.findViewById(R.id.textViewInfo);
        textoDescricao = (TextView) this.findViewById(R.id.textViewDescricao);
        textoPreco = (TextView) this.findViewById(R.id.textViewPreco);
        foto = (ImageView) this.findViewById(R.id.imagem);

        Intent intentPedido= getIntent();
        idMesa = intentPedido.getIntExtra("IDmesa",0);
        idItem = intentPedido.getIntExtra("IDproduto",0);
        idPedido = intentPedido.getIntExtra("IDpedido",0);
    }

    protected void onStart(){
        super.onStart();

        listaProduto = BancoFake.getInstancia().getListaProduto();
        textoNome.setText(listaProduto.get(idItem).getNome());
        textoPreco.setText("R$ "+ Double.toString(listaProduto.get(idItem).getPreco()) + "0");
        textoDescricao.setText(listaProduto.get(idItem).getDescricao());
        if(listaProduto.get(idItem).getFoto()!=null) {
            int resID = this.getResources().getIdentifier(listaProduto.get(idItem).getFoto(), null, this.getPackageName());
            foto.setImageResource(resID);
        }
    }

    public void botaoAumenta(View view){
        quantidade++;
        textoQuantidade.setText(Integer.toString(quantidade));
    }

    public void botaoDiminui(View view){
        if(quantidade>0){
            quantidade--;
            textoQuantidade.setText(Integer.toString(quantidade));
        }
    }

    public void botaoPedir(View view){
        if(quantidade==0){
            new AlertDialog.Builder(QuantidadeItem.this)
                    .setTitle("Quantidade indisponível")
                    .setMessage("Quantidade deve ser maior que zero")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Ok",null).show();
        }
        else {
            BancoFake.getInstancia().adicionaItemPedido(idPedido, quantidade, idItem);
            Intent intentPedido = new Intent(QuantidadeItem.this, MainActivity.class);
            startActivity(intentPedido);
        }
    }
}