package com.example.daniel.cdo.Home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.daniel.cdo.Categorias.RecyclerViewOnClickListenerHack;
import com.example.daniel.cdo.Categorias.TelaCategoriasActivity;
import com.example.daniel.cdo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewOnClickListenerHack {

    private static final String BASE_URL = "https://cadernodeofertas.tk/api/v1/";
    private AnuncioAdapter adapter;
    public AnuncioWebService webService;
    public String util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        carregarPagina();

        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carregarPagina();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void carregarPagina() {
        final ProgressDialog progressDialog = new ProgressDialog(TelaHomeActivity.this);
        progressDialog.setTitle("Recebendo dados do servidor...");
        progressDialog.setMessage("Por favor, aguarde.");
        progressDialog.show();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AnuncioAdapter();
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webService = retrofit.create(AnuncioWebService.class);

        Call<AnuncioList> call = webService.getAnuncios();

        adapter.setRecyclerViewOnClickListenerHack(this);

        call.enqueue(new Callback<AnuncioList>() {
            @Override
            public void onResponse(Call<AnuncioList> call, Response<AnuncioList> response) {
                AnuncioList anuncioList = response.body();
                adapter.setAnuncios(anuncioList);
                progressDialog.dismiss();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AnuncioList> call, Throwable t) {
                Log.e("TelaHomeActivity", t.toString());
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

        if (id == R.id.home_home) {
            // Permanece na tela.
        } else if (id == R.id.home_categorias) {
            finish();
            Intent vaiPraCategorias = new Intent(TelaHomeActivity.this, TelaCategoriasActivity.class);
            startActivity(vaiPraCategorias);
        } else if (id == R.id.home_sair) {
            finish();
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClickListener(View view, int position) {
        util = position + "1";
        Toast.makeText(this, "Posição: " + util, Toast.LENGTH_SHORT).show();
    }
}
