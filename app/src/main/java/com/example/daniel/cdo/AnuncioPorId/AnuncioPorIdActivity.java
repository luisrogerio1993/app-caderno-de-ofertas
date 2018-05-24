package com.example.daniel.cdo.AnuncioPorId;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.daniel.cdo.Categorias.TelaCategoriasActivity;
import com.example.daniel.cdo.Home.AnuncioAdapter;
import com.example.daniel.cdo.Home.AnuncioList;
import com.example.daniel.cdo.Home.TelaHomeActivity;
import com.example.daniel.cdo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnuncioPorIdActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String BASE_URL = "https://cadernodeofertas.tk/api/v1/";
    private AnuncioAdapter adapter;
    public AnuncioPorIdWebService webService;
    public int util;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_por_id);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        carregarPagina();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void carregarPagina() {
        final ProgressDialog progressDialog = new ProgressDialog(AnuncioPorIdActivity.this);
        progressDialog.setTitle("Recebendo dados do servidor...");
        progressDialog.setMessage("Por favor, aguarde.");
        progressDialog.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Falha ao carregar o conteúdo.");
        builder.setMessage("Tente novamente mais tarde.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent vaiPraCategorias = new Intent(AnuncioPorIdActivity.this, TelaCategoriasActivity.class);
                startActivity(vaiPraCategorias);
            }
        });

        alerta = builder.create();

        Intent it = getIntent();
        util = it.getIntExtra("parametro", 0);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_a);
        recyclerView.hasFixedSize();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AnuncioAdapter();
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webService = retrofit.create(AnuncioPorIdWebService.class);

        Call<AnuncioList> call = webService.buscaAnuncio(util);

        call.enqueue(new Callback<AnuncioList>() {
            @Override
            public void onResponse(Call<AnuncioList> call, Response<AnuncioList> response) {
                AnuncioList anuncioList = response.body();
                if(anuncioList != null) {
                    adapter.setAnuncios(anuncioList);
                    progressDialog.dismiss();
                    adapter.notifyDataSetChanged();
                }else {
                    progressDialog.dismiss();
                    alerta.show();
                }
            }

            @Override
            public void onFailure(Call<AnuncioList> call, Throwable t) {
                Log.e("AnuncioPorIdActivity", t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.aid_home) {
            finish();
            Intent vaiPraHome = new Intent(AnuncioPorIdActivity.this, TelaHomeActivity.class);
            startActivity(vaiPraHome);
        } else if (id == R.id.aid_categoria) {
            finish();
            Intent vaiPraCategorias = new Intent(AnuncioPorIdActivity.this, TelaCategoriasActivity.class);
            startActivity(vaiPraCategorias);
        } else if (id == R.id.aid_sair) {
            finish();
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}