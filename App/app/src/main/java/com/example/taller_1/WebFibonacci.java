package com.example.taller_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebFibonacci extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_fibonacci);
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
    }
}