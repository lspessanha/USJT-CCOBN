package br.com.siqueira.servicedeskccp3anbua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ChamadosAdapter extends ArrayAdapter <Chamado> {

    private List <Chamado> chamados;
    private Context context;
    public ChamadosAdapter (List <Chamado> chamados, Context context){
        super(context, -1, chamados);
        this.chamados = chamados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public Chamado getItem(int position) {
        return chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chamado deInteresse = chamados.get(position);

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView filaDoItemTextView = convertView.findViewById(R.id.filaDoItemTextView);
        TextView descricaoDoItemTextView = convertView.findViewById(R.id.descricaoDoItemTextView);
        filaDoItemTextView.setText(deInteresse.getFila());
        descricaoDoItemTextView.setText(deInteresse.getDescricao());
        return convertView;
    }
}
