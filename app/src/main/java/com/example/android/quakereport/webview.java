package com.example.android.quakereport;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class webview extends AppCompatActivity {
    private WebView webview;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent myIntent = getIntent(); // gets the previously created intent
        String url = myIntent.getStringExtra("url");


//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_webview);
        this.webview = (WebView) findViewById(R.id.webview);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);


        progressBar = ProgressDialog.show(webview.this, "Getting Information", "Please wait...");

        webview.setWebViewClient(new WebViewClient() {


            public void onPageFinished(WebView view, String url) {

                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }


            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Context context = getApplicationContext();
                CharSequence text = "You don't have internet connection";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                onBackPressed();
            }


        });
        webview.loadUrl(url);
    }
}