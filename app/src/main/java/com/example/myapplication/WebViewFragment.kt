package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mWebView = view.findViewById<WebView>(R.id.web_view)

        val webSettings: WebSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()

        val value = arguments?.getString("url")
        if(value!=null) {
            mWebView.loadUrl(value.toString())
        }
        val btn = view.findViewById<Button>(R.id.close_button)
        btn.setOnClickListener {
            btn.visibility = View.GONE
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container1, Fragment2())?.commit()
        }
    }

}