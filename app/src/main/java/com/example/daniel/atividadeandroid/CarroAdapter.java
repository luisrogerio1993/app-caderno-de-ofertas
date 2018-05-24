package com.example.daniel.atividadeandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarroAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Carro> carros;

    public CarroAdapter(Context context, ArrayList<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return this.carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.item_carro, null);

        Carro carro = this.carros.get(position);

        TextView textViewNome = v.findViewById(R.id.nome_carro);
        textViewNome.setText(carro.getNome());
        TextView textViewDesc = v.findViewById(R.id.desc_carro);
        textViewDesc.setText(carro.getDescricao());

        ImageView image = v.findViewById(R.id.img_carro);
        Picasso.get().load(carro.getUrlImg()).into(image);

        return v;
    }
}
