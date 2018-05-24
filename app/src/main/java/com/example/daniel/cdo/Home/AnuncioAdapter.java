package com.example.daniel.cdo.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.cdo.Categorias.RecyclerViewOnClickListenerHack;
import com.example.daniel.cdo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioViewHolder>{

    private List<Anuncio> anuncios;
    private RecyclerViewOnClickListenerHack recyclerViewOnClickListenerHack;

    public AnuncioAdapter() {
        this.anuncios = new ArrayList<Anuncio>();
    }

    public AnuncioAdapter(List<Anuncio> listaAnuncios) {
        this.anuncios = listaAnuncios;
    }

    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_anuncio, parent, false);
        AnuncioViewHolder anuncioViewHolder = new AnuncioViewHolder(view);

        return anuncioViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioViewHolder holder, int position) {
        Anuncio anuncio = anuncios.get(position);

        holder.nome_anuncio.setText(anuncio.getNome());
        holder.valor_atual_anuncio.setText(anuncio.getValor_atual());
        if(anuncio.getUrlImg() != null && !anuncio.getUrlImg().isEmpty()) {
            Picasso.get().load(anuncio.getUrlImg()).into(holder.img_anuncio);
        }
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        recyclerViewOnClickListenerHack = r;
    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }

    public void setAnuncios(AnuncioList anunciosL) {
        this.anuncios = anunciosL.getAnuncios();
    }

    public class AnuncioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView img_anuncio;
        public TextView nome_anuncio;
        public TextView valor_atual_anuncio;

        public AnuncioViewHolder(View itemView) {
            super(itemView);

            img_anuncio = itemView.findViewById(R.id.img_anuncio);
            nome_anuncio = itemView.findViewById(R.id.nome_anuncio);
            valor_atual_anuncio = itemView.findViewById(R.id.valor_atual_anuncio);
        }

        @Override
        public void onClick(View v) {
            if(recyclerViewOnClickListenerHack != null) {
                recyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }
}
