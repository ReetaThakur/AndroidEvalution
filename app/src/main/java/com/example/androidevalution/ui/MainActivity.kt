package com.example.androidevalution.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidevalution.R
import com.example.androidevalution.responseData.ApiService
import com.example.androidevalution.responseData.Network
import com.example.androidevalution.responseData.ResponseModel
import com.example.androidevalution.responseData.ResponseModelItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var actorAdapter: ActorAdapte
    private lateinit var viewModel: ActorViewModel
    private lateinit var acotrList:ArrayList<ResponseModelItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this).get(ActorViewModel::class.java)
        setAdapter()
        viewModel.searchPage().observe(this,{
            it.let {
                CoroutineScope(Dispatchers.Main).launch {
                    actorAdapter.submitData(it)
                }
            }
        })
    }

    private fun setAdapter() {
        actorAdapter= ActorAdapte()
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager=linearLayoutManager
            this.adapter=actorAdapter
        }
    }


}