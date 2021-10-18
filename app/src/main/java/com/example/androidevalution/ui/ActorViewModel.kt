package com.example.androidevalution.ui

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.androidevalution.repository.RepositoryClass
import com.example.androidevalution.responseData.ResponseModelItem

class ActorViewModel():ViewModel() {
    private val repository= RepositoryClass()
    fun searchPage()=repository.getPageList()

    fun addActor(responseModelItem: PagingData<ResponseModelItem>){
        repository.addActorDetailsToRoom(responseModelItem)

    }
}