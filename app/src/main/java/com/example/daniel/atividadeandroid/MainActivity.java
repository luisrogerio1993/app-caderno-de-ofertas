package com.example.daniel.atividadeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lista_main);

        final ArrayList<Carro> lista_carros = new ArrayList<>();

        Carro c1 = new Carro("Mustang", "Mustang 2018", "https://auto.ndtvimg.com/car-images/gallery/ford/mustang/exterior/ford-mustang-front_3-4th_view.jpg?v=2016-08-02");
        Carro c2 = new Carro("Ferrari", "Ferrari 2016", "https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/wp-content/uploads/2015/02/2016-Ferrari-488GTB-102.jpg");
        Carro c3 = new Carro("Bugatti Veyron", "Bugatti Veyron 2018", "http://2018viewcar.club/wp-content/uploads/2018/04/2018-bugatti-veyron-review-1-1024x577.jpg");

        lista_carros.add(c1);
        lista_carros.add(c2);
        lista_carros.add(c3);

        CarroAdapter adapter = new CarroAdapter(MainActivity.this, lista_carros);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carro carro = lista_carros.get(position);

                Intent intent = new Intent(MainActivity.this, DetalhesCarroActivity.class);
                intent.putExtra("carroSelecionado", carro);
                startActivity(intent);
            }
        });

    }
}
