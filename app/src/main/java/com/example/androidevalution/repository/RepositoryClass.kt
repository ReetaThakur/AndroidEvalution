package com.example.androidevalution.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.androidevalution.ActorPagingSource

class RepositoryClass {

    fun getPageList()= Pager(config = PagingConfig(pageSize = 20),pagingSourceFactory = {ActorPagingSource()}).liveData
}