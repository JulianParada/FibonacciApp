package com.example.taller_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    TextView mult, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        mult = findViewById(R.id.multiplicacion);
        res = findViewById(R.id.resultado);
        createFactorial();
    }

    public void createFactorial(){
        int fac = Integer.parseInt(getIntent().getStringExtra("sp"));
        String title = "Operación: ";
        int result = 1;
        for(int i = 2; i <= fac; i++){
            result = result * i;
        }

        for(int i = 1; i < fac; i++){
            title = title + (i + "*");
        }
        title += (""+fac);
        mult.setText(title);
        res.setText("Resultado: " + result);
    }
}