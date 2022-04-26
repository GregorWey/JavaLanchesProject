package pdm.carlos.android.javalanches.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.classes.PedidoItem;

public class PedidoItemAdapter extends ArrayAdapter<PedidoItem> {
    private final Context context;
    private final ArrayList<PedidoItem> elementos;

    public PedidoItemAdapter (Context context, ArrayList<PedidoItem> elementos){
        super(context, R.layout.layout_pedido_item, elementos);
        this.context=context;
        this.elementos=elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_pedido_item,parent,false);
        TextView produtoNome = (TextView) rowView.findViewById(R.id.textViewProduto);
        TextView produtoValor = (TextView) rowView.findViewById(R.id.textViewValorProduto);
        TextView produtoQuantidade = (TextView) rowView.findViewById(R.id.textViewQuantidadeProduto);
        ImageView produtoImagem = (ImageView) rowView.findViewById(R.id.imagemItem);
        produtoNome.setText(elementos.get(position).getProdutoNome());
        produtoValor.setText("R$ "+Double.toString(elementos.get(position).getProdutoValor()) + "0");
        produtoQuantidade.setText(Integer.toString(elementos.get(position).getQuantidade()));

        if(elementos.get(position).getFoto()!=null){
            int resID = context.getResources().getIdentifier(elementos.get(position).getFoto(),null,context.getPackageName());
            produtoImagem.setImageResource(resID);
        }
        return rowView;
    }
}
