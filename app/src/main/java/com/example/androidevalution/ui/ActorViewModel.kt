package com.example.androidevalution.ui

import androidx.lifecycle.ViewModel
import com.example.androidevalution.repository.RepositoryClass

class ActorViewModel():ViewModel() {
    private val repository= RepositoryClass()
    fun searchPage()=repository.getPageList()
}