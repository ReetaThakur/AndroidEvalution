package com.example.androidevalution.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidevalution.R
import com.example.androidevalution.responseData.ApiService
import com.example.androidevalution.responseData.Network
import com.example.androidevalution.responseData.ResponseModel
import com.example.androidevalution.responseData.ResponseModelItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var actorAdapter: ActorAdapter
    private lateinit var acotrList:ArrayList<ResponseModelItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
    }

    private fun setData() {
        val apiCall = Network.getRetrofit().create(ApiService::class.java)
        apiCall.getInstance(1).enqueue(object : Callback<List<ResponseModel>> {
            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>,
            ) {
                acotrList=response.body() as ArrayList<ResponseModelItem>
                actorAdapter= ActorAdapter(acotrList)
                val linearLayoutManager=LinearLayoutManager(this@MainActivity)
                recyclerView.adapter=actorAdapter
                recyclerView.layoutManager=linearLayoutManager

            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}