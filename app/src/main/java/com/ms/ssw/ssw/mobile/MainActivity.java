package com.ms.ssw.ssw.mobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    private String url = "https://michail19.github.io/SimpleScheduleWork/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            // Переход в WebActivity
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
            finish();
        } catch (Throwable t) {
            // Если WebView или Activity падает — fallback
            openInExternalBrowser(this, url);
        }
    }

    private void openInExternalBrowser(Context context, String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "Ошибка при открытии ссылки: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // Назад в WebView
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

