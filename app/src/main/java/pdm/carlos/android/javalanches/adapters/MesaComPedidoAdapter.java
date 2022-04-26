package pdm.carlos.android.javalanches.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import pdm.carlos.android.javalanches.R;
import pdm.carlos.android.javalanches.activities.BancoFake;
import pdm.carlos.android.javalanches.classes.Mesa;

import java.util.ArrayList;

public class MesaComPedidoAdapter extends ArrayAdapter<Mesa> {
    private final Context context;
    private final ArrayList<Mesa> elementos;

    public MesaComPedidoAdapter(Context context, ArrayList<Mesa> elementosMesa){
        super(context, R.layout.layout_mesa_com_pedido, elementosMesa);
        this.context=context;
        this.elementos = elementosMesa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_mesa_com_pedido, parent, false);
        TextView numeroPedido = (TextView) rowView.findViewById(R.id.textoNumeroPedido);
        TextView mesaNumero = (TextView) rowView.findViewById(R.id.textoNumeroMesa);
        TextView mesaDetalhe = (TextView) rowView.findViewById(R.id.textoDetalhe);
        numeroPedido.setText("PEDIDO " + Integer.toString(BancoFake.getInstancia().getPedidoId(elementos.get(position).getCodigo())));
        mesaNumero.setText("MESA " + Integer.toString(elementos.get(position).getCodigo()));
        mesaDetalhe.setText("DETALHES");
        return rowView;
    }
}