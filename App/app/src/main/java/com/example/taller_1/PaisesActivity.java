package com.example.taller_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import Model.Pais;

public class PaisesActivity extends AppCompatActivity {

    ArrayList<Pais> paises = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        initArray();
        ArrayAdapter<Pais> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), PaisDetailActivity.class);
                Pais actual = (Pais) adapterView.getItemAtPosition(i);
                intent.putExtra("name", actual.getName());
                intent.putExtra("capital", actual.getCapital());
                intent.putExtra("name_int", actual.getName_int());
                intent.putExtra("sigla", actual.getCode());
                startActivity(intent);
            }
        });
    }

    public void initArray() {
        try{
            JSONObject json = new JSONObject(loadJSONFromAsset());
            JSONArray paisesJ = json.getJSONArray("paises");
            for(int i = 0; i < paisesJ.length(); i++) {
                JSONObject jsonO = paisesJ.getJSONObject(i);
                Pais newPais = new Pais(jsonO.getString("nombre_pais"), jsonO.getString("capital"),
                        jsonO.getString("nombre_pais_int"), jsonO.getString("sigla"));
                paises.add(newPais);
            }
        }catch(JSONException ex){
            ex.printStackTrace();
        }
    }

    public String loadJSONFromAsset(){
        String json = null;
        try{
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch(IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}