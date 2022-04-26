package pdm.carlos.android.javalanches.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.classes.Bebida;

import java.util.ArrayList;

public class BebidaAdapter extends ArrayAdapter<Bebida> {
    private final Context context;
    private final ArrayList<Bebida> elementos;

    public BebidaAdapter(Context context, ArrayList<Bebida> elementosBebida){
        super(context, R.layout.layout_bebidas,elementosBebida);
        this.context=context;
        this.elementos=elementosBebida;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_bebidas,parent,false);
        TextView bebidaNome = (TextView) rowView.findViewById(R.id.nomeBebida);
        TextView bebidaEmbalagem = (TextView) rowView.findViewById(R.id.embalagemBebida);
        TextView bebidaDescricao = (TextView) rowView.findViewById(R.id.descricaoBebida);
        TextView bebidaValor = (TextView) rowView.findViewById(R.id.valorBebida);
        ImageView bebidaImagem = (ImageView) rowView.findViewById(R.id.imagemBebida);
        bebidaNome.setText(elementos.get(position).getNome());
        bebidaEmbalagem.setText(elementos.get(position).getEmbalagem());
        bebidaDescricao.setText(elementos.get(position).getDescricao());
        bebidaValor.setText("R$ "+ Double.toString(elementos.get(position).getPreco()) + "0");

        if(elementos.get(position).getFoto()!=null){
            int resID = context.getResources().getIdentifier(elementos.get(position).getFoto(),null,context.getPackageName());
            bebidaImagem.setImageResource(resID);
        }
        return rowView;
    }
}
