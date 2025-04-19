package com.ms.ssw.ssw.mobile;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main); // можно создать отдельный layout, если хочешь

            webView = findViewById(R.id.webView);

            String url = getIntent().getStringExtra("url");

            WebSettings webSettings = webView.getSettings();
            webSettings.setDomStorageEnabled(true); // Включаем localStorage
            webSettings.setJavaScriptEnabled(true); // Включаем JavaScript
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);

            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);

        } catch (Throwable t) {
            Toast.makeText(this, "Ошибка WebView: " + t.getMessage(), Toast.LENGTH_LONG).show();
            finish(); // Закрыть активити
        }
    }
}

