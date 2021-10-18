package com.example.androidevalution.roomdatabase

import androidx.paging.PagingData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.androidevalution.responseData.ResponseModelItem


@Dao
interface ActorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addActorDetail(responseList:PagingData<ResponseModelItem>)
}