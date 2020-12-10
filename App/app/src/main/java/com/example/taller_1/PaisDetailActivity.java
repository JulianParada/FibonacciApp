package com.example.taller_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PaisDetailActivity extends AppCompatActivity {

    TextView name, capital, nameInt, sigla;
    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais_detail);
        name = findViewById(R.id.namePais);
        capital = findViewById(R.id.capital);
        nameInt = findViewById(R.id.nameInt);
        sigla = findViewById(R.id.sigla);
        flag = findViewById(R.id.imgFlag);

        name.setText(getIntent().getStringExtra("name"));
        capital.setText(getIntent().getStringExtra("capital"));
        nameInt.setText(getIntent().getStringExtra("name_int"));
        sigla.setText(getIntent().getStringExtra("sigla"));
        showImage();
    }

    public void showImage(){
        Resources res = getResources();
        int resId = res.getIdentifier(sigla.getText().toString().toLowerCase(), "drawable", getPackageName());
        flag.setImageResource(resId);
    }
}