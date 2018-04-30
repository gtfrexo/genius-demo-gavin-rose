package com.gtfrexo.geniusdemo_gavinrose

import android.os.AsyncTask
import android.os.AsyncTask.execute
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.net.URL
import java.net.URLConnection
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create endpoint reference and open connection.
        val reqresEndpoint = URL("https://reqres.in/api/users")
        val reqresConnection = reqresEndpoint.openConnection() as HttpsURLConnection
        reqresConnection.setRequestProperty("User-Agent", "genius-demo-gavin-rose-v0.1")

        //Create background thread here.
        //Usually, I would use RxJava or Coroutines for Asynchronous tasks.
        AsyncTask.execute {

        }
    }
}
