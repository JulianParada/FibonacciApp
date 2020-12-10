package com.example.taller_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Pais;

public class FibonacciActivity extends AppCompatActivity {

    ImageButton imgFib;
    ScrollView scroll;
    LinearLayout layout;
    ArrayList<Integer> sec = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        scroll = findViewById(R.id.scroll);
        imgFib = findViewById(R.id.imgFib);
        layout = (LinearLayout) findViewById(R.id.layoutFib);
        imgFib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WebFibonacci.class);
                startActivity(intent);
            }
        });
        createSequence();

    }

    public void createSequence(){
        int pos = Integer.parseInt(getIntent().getStringExtra("pos"));
        sec.add(0);
        sec.add(1);
        for(int i = 1; i < pos; i++){
            int a = sec.get(i - 1);
            int b = sec.get(i);
            sec.add(a + b);
        }

        for(Integer i: sec){
            TextView t = new TextView(this);
            t.setText(""+i);
            t.setId(i);
            t.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) layout).addView(t);
        }
    }
}