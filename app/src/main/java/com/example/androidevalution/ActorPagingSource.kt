package com.example.androidevalution

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.androidevalution.responseData.Network
import com.example.androidevalution.responseData.ResponseModel
import com.example.androidevalution.responseData.ResponseModelItem
import retrofit2.Call

class ActorPagingSource:PagingSource<Int,ResponseModelItem>() {

    private val apiCall=Network.getApiService()
    override fun getRefreshKey(state: PagingState<Int, ResponseModelItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModelItem> {
        val pageNumber=params.key?:0
        val responseModelItem =apiCall.getInstance(pageNumber)
        val responseList:ArrayList<ResponseModelItem> =responseModelItem as ArrayList<ResponseModelItem>
        return try {
           LoadResult.Page(data = responseList,prevKey = null,nextKey = if (responseList.isEmpty()) null else pageNumber+1)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}