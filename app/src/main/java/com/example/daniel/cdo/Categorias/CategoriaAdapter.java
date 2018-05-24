package com.example.daniel.cdo.Categorias;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.cdo.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>{

    private List<Categoria> categorias;
    private RecyclerViewOnClickListenerHack recyclerViewOnClickListenerHack;

    public CategoriaAdapter() {
        this.categorias = new ArrayList<Categoria>();
    }

    public CategoriaAdapter(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_lista, parent, false);
        CategoriaViewHolder categoriaViewHolder = new CategoriaViewHolder(view);
        return categoriaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);

        holder.tv_lista_anuncio.setText(categoria.getNome());
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r) {
        recyclerViewOnClickListenerHack = r;
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public void setCategoriaList(CategoriaList categoriaList) {
        this.categorias = categoriaList.getCategorias();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv_lista_anuncio;

        public CategoriaViewHolder(View itemView) {
            super(itemView);

            tv_lista_anuncio = itemView.findViewById(R.id.tv_lista_anuncio);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(recyclerViewOnClickListenerHack != null) {
                recyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }
}
