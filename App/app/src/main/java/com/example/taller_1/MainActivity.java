package com.example.taller_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnFib, btnFac, btnPais;
    EditText txtPos;
    TextView txtFib, txtFac, txtFibDate, txtFacDate;
    Spinner sp;

    String dateFib = "", dateFac = "";
    int visitFib = 0, visitFac = 0;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("fibCount", visitFib);
        outState.putInt("facCount", visitFac);
        outState.putString("fibDate", dateFib);
        outState.putString("facDate", dateFac);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        visitFib = savedInstanceState.getInt("fibCount");
        visitFac = savedInstanceState.getInt("facCount");
        dateFib = savedInstanceState.getString("fibDate");
        dateFac = savedInstanceState.getString("facDate");
        txtFac.setText("Visitas a factorial: " + visitFac);
        txtFib.setText("Visitas a Fibonacci: " + visitFib);
        txtFibDate.setText("Última visita a Fibonacci: " + dateFib);
        txtFacDate.setText("Última visita a Factorial: " + dateFac);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFib = findViewById(R.id.btnFib);
        btnFac = findViewById(R.id.btnFac);
        btnPais = findViewById(R.id.btnPais);
        txtPos = findViewById(R.id.txtPos);
        sp = findViewById(R.id.spinner);
        txtFac = findViewById(R.id.facCount);
        txtFib = findViewById(R.id.fibCount);
        txtFacDate = findViewById(R.id.facDate);
        txtFibDate = findViewById(R.id.fibDate);
        txtFac.setText("Visitas a factorial: " + visitFac);
        txtFib.setText("Visitas a Fibonacci: " + visitFib);
        txtFibDate.setText("Última visita a Fibonacci: " + dateFib);
        txtFacDate.setText("Última visita a Factorial: " + dateFac);

        btnFib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), FibonacciActivity.class);
                visitFib++;
                dateFib = getTime();
                txtFib.setText("Visitas a Fibonacci: " + visitFib);
                txtFibDate.setText("Última visita a Fibonacci: " + dateFib);
                intent.putExtra("pos", txtPos.getText().toString());
                startActivity(intent);
            }
        });

        btnFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitFac++;
                txtFac.setText("Visitas a factorial: " + visitFac);
                dateFac = getTime();
                txtFacDate.setText("Última visita a Factorial: " + dateFac);
                Intent intent = new Intent(getBaseContext(), FactorialActivity.class);
                intent.putExtra("sp", sp.getSelectedItem().toString());
                startActivity(intent);
            }
        });

        btnPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PaisesActivity.class);
                startActivity(intent);
            }
        });
    }

    public String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -5);
        return df.format(cal.getTime());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}