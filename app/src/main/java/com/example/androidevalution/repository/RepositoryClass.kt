package com.example.androidevalution.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.androidevalution.ActorPagingSource
import com.example.androidevalution.responseData.ApiService
import com.example.androidevalution.responseData.Network
import com.example.androidevalution.responseData.ResponseModelItem
import com.example.androidevalution.roomdatabase.ActorDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoryClass {

    fun getPageList()= Pager(config = PagingConfig(pageSize = 10),pagingSourceFactory = {ActorPagingSource()}).liveData

     private val api:ApiService=Network.getApiService()
    private lateinit var actorDAO:ActorDAO

    fun addActorDetailsToRoom(responseModelItem: PagingData<ResponseModelItem>){
        CoroutineScope(Dispatchers.IO).launch {
            actorDAO.addActorDetail(responseModelItem)
        }
    }

}