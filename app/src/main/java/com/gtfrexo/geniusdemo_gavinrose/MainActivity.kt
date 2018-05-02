package com.gtfrexo.geniusdemo_gavinrose

import android.net.http.HttpResponseCache
import android.os.AsyncTask
import android.os.AsyncTask.execute
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.JsonReader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create background thread here.
        //Usually, I would use RxJava or Coroutines for Asynchronous tasks.
        AsyncTask.execute {
            //Create endpoint reference and open connection.
            val reqresEndpoint = URL("https://reqres.in/api/users")
            val reqresConnection = reqresEndpoint.openConnection() as HttpsURLConnection
            reqresConnection.setRequestProperty("User-Agent", "genius-demo-gavin-rose-v0.1")

            //Check to see if connected properly to endpoint.
            if (reqresConnection.responseCode === 200) {

                //Continue application and open input stream
                val reqresResponse = reqresConnection.inputStream
                val reqresResponseReader = InputStreamReader(reqresResponse, "UTF-8")
                val reqresJsonReader = JsonReader(reqresResponseReader)
                val reqresCache = HttpResponseCache.install(cacheDir, 100000L)
                //Create arrays to hold data
                val reqresFirstName: ArrayList<String> = ArrayList()
                val reqresLastName: ArrayList<String> = ArrayList()
                val reqresAvatar: ArrayList<String> = ArrayList()

                //Check to see if cache is working. If it is, it will automatically be used,
                //allowing us to have a faster application and to save bandwidth. If it isn't
                //working, connection will be slower and app will not be as responsive.
                if (reqresCache.hitCount > 0) {
                    //reqresCache is storing data
                }
                reqresJsonReader.beginObject()
                while (reqresJsonReader.hasNext())
                {
                    val key = reqresJsonReader.nextName()
                    when (key) {
                        "first_name" -> {
                            //Add to array
                            val firstName = reqresJsonReader.nextString()
                            reqresFirstName.add(firstName)
                        }
                        "last_name" -> {
                            //Add to array
                            val lastName = reqresJsonReader.nextString()
                            reqresLastName.add(lastName)
                        }
                        "avatar" -> {
                            //Add to array
                            val avatar = reqresJsonReader.nextString()
                            reqresAvatar.add(avatar)
                        }
                    }
                    reqresJsonReader.skipValue()
                }

                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = DataAdapter(reqresFirstName, reqresLastName, reqresAvatar, this)

                //Close stream, connection, and readers
                reqresJsonReader.close()
                reqresConnection.disconnect()

            } else {
                //Error with connection
            }
        }
    }
}
