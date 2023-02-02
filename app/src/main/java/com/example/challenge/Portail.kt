package com.example.challenge

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Portail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portail)

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://sitescours.monportail.ulaval.ca/ena/site/accueil?idSite=152945&_js=true&idPage=3814963")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        val buttonAgenda = findViewById<Button>(R.id.buttonAct3)
        buttonAgenda.setOnClickListener {
            val intent= Intent(this, Agenda::class.java)
            startActivity(intent)
        }
    }




}