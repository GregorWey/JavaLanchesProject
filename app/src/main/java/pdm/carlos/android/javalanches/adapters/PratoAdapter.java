package pdm.carlos.android.javalanches.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.classes.Prato;

import java.util.ArrayList;

public class PratoAdapter extends ArrayAdapter<Prato> {
    private final Context context;
    private final ArrayList<Prato> elementos;

    public PratoAdapter(Context context, ArrayList<Prato> elementosPrato){
        super(context, R.layout.layout_prato,elementosPrato);
        this.context=context;
        this.elementos=elementosPrato;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_prato,parent,false);
        TextView pratoNome = (TextView) rowView.findViewById(R.id.nomePrato);
        TextView pratoPessoas = (TextView) rowView.findViewById(R.id.pessoasPrato);
        TextView pratoDescricao = (TextView) rowView.findViewById(R.id.descricaoPrato);
        TextView pratoValor = (TextView) rowView.findViewById(R.id.valorPrato);
        ImageView pratoImagem = (ImageView) rowView.findViewById(R.id.imagemPrato);
        pratoNome.setText(elementos.get(position).getNome());
        pratoPessoas.setText("Serve: " +elementos.get(position).getServePessoas()+" pessoas");
        pratoDescricao.setText(elementos.get(position).getDescricao());
        pratoValor.setText("R$ "+ Double.toString(elementos.get(position).getPreco()) + "0");

        if(elementos.get(position).getFoto()!=null){
            int resID = context.getResources().getIdentifier(elementos.get(position).getFoto(),null,context.getPackageName());
            pratoImagem.setImageResource(resID);
        }
        return rowView;
    }
}
