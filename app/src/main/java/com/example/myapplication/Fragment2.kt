package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.FragmentManager

class Fragment2 : Fragment() {
    private var webViewFragment=WebViewFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_2 ,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()
        bundle.putString("url", "https://www.foxnews.com/media/anti-capitalism-meme-comparing-fast-food-chicken-sandwiches-backfires-massively")
        webViewFragment.arguments = bundle

        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.container1, webViewFragment)
            ?.hide(webViewFragment)
            ?.commit()

        val button = view.findViewById<View>(R.id.button)
        button.setOnClickListener {
            button.visibility = View.GONE
            showWebViewFragment()
        }
    }

    private fun showWebViewFragment() {
        webViewFragment.arguments?.putString("url", "https://www.foxnews.com/media/anti-capitalism-meme-comparing-fast-food-chicken-sandwiches-backfires-massively")
        activity?.supportFragmentManager?.beginTransaction()
            ?.show(webViewFragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}