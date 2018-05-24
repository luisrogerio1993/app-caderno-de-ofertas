package com.example.daniel.cdo.Categorias;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.daniel.cdo.AnuncioPorId.AnuncioPorIdActivity;
import com.example.daniel.cdo.Home.TelaHomeActivity;
import com.example.daniel.cdo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaCategoriasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewOnClickListenerHack{

    public static final String BASE_URL = "https://cadernodeofertas.tk/api/v1/";
    private CategoriaAdapter adapter;
    public int util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categorias);
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

    public void carregarPagina() {
        final ProgressDialog progressDialog = new ProgressDialog(TelaCategoriasActivity.this);
        progressDialog.setTitle("Recebendo dados do servidor...");
        progressDialog.setMessage("Por favor, aguarde.");
        progressDialog.show();

        RecyclerView recyclerView = findViewById(R.id.recycler_view_c);
        recyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoriaAdapter();

        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriaWebService webService = retrofit.create(CategoriaWebService.class);

        Call<CategoriaList> call = webService.getCategorias();

        adapter.setRecyclerViewOnClickListenerHack(this);

        call.enqueue(new Callback<CategoriaList>() {
            @Override
            public void onResponse(Call<CategoriaList> call, Response<CategoriaList> response) {
                CategoriaList categoriaList = response.body();
                adapter.setCategoriaList(categoriaList);
                progressDialog.dismiss();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CategoriaList> call, Throwable t) {
                Log.e("TelaCategoriasActivity", t.toString());
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

        if (id == R.id.cat_home) {
            finish();
            Intent vaiPraHome = new Intent(TelaCategoriasActivity.this, TelaHomeActivity.class);
            startActivity(vaiPraHome);
        } else if (id == R.id.cat_categorias) {
            //Permanece na tela atual
        } else if (id == R.id.cat_sair) {
            finish();
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClickListener(View view, int position) {
        util = position + 1;
//        Toast.makeText(this, "Posição: " + util, Toast.LENGTH_SHORT).show();

        finish();
        Intent intent = new Intent(this, AnuncioPorIdActivity.class);
        intent.putExtra("parametro", util);
        startActivity(intent);
    }
}
