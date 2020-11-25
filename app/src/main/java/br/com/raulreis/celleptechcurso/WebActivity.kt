package br.com.raulreis.celleptechcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        // habilitando a execução de codigo JavaScript no WebView
        wbvWeb.settings.javaScriptEnabled = true

        //carregar uma página web (URL) no Webview
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack")

        //Definindo o WebView como cliente padrão
        wbvWeb.webViewClient= WebViewClient()
    }
}