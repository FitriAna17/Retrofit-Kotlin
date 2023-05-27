package com.example.retrofit_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rick = findViewById<RecyclerView>(R.id.rv_karakter)

        ApiConfig.getService().getRick().enqueue(object : Callback<Responsemorty>{
            override fun onResponce(call: Call<Responsemorty>,response: Response<Responsemorty>) {
                if (response.isSuccessful) {
                    val responsemorty = response.body()
                    val dataRick = responsemorty?.results
                    val rickAdapter = RickAdapter(dataRick as List<ResultsItem>)
                    rick.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter = rickAdapter
                    }
                }
            }
                override fun onFailure (call: Call<Responsemorty>,t: Throwable){
                    Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
        }}
    }
