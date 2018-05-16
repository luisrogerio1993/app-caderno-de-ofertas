package com.example.daniel.atividadeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalhesCarroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_carro);

        Carro carro = (Carro) getIntent().getSerializableExtra("carroSelecionado");

        TextView tv_nome = findViewById(R.id.detalhe_nome_carro);
        TextView tv_desc = findViewById(R.id.detalhe_descricao_carro);
        ImageView img_carro = findViewById(R.id.img_recebida);
        Button btn_voltar = findViewById(R.id.btn_voltar);

        tv_nome.setText(carro.getNome());
        tv_desc.setText(carro.getDescricao());
        Picasso.get().load(carro.getUrlImg()).into(img_carro);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
