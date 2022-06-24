package com.example.cetakfotoku2;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
        implements com.example.cetakfotoku2.KeranjangBelanjaListener {

    private RecyclerView rvKatalogFoto;
    private com.example.cetakfotoku2.KatalogFotoListAdapter adapter;
    private Button btnKeranjangBelanja;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.example.cetakfotoku2.KatalogFotoUtil.init();
        com.example.cetakfotoku2.OrderFotoUtil.init();

        rvKatalogFoto = findViewById(R.id.rv_katalog_foto);
        adapter = new com.example.cetakfotoku2.KatalogFotoListAdapter(this);

        rvKatalogFoto.setAdapter((adapter));
        rvKatalogFoto.setLayoutManager(new LinearLayoutManager(this));

        btnKeranjangBelanja = findViewById(R.id.btn_keranjang_belanja);
        orderChanged();
        btnKeranjangBelanja.setOnClickListener(view -> {
            Intent intent = new Intent(this, com.example.cetakfotoku2.KeranjangBelanjaActivity.class);
            startActivity(intent);
        });

        com.example.cetakfotoku2.OrderFotoUtil.addKbListener(this);
    }

    @Override
    public void orderChanged() {
        String kbCountStr = "Keranjang Belanja: " + com.example.cetakfotoku2.OrderFotoUtil.getOrderCount();
        btnKeranjangBelanja.setText(kbCountStr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App telah di-resume",Toast.LENGTH_SHORT).show();
    }
}