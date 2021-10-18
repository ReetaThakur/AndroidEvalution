package com.example.androidevalution.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidevalution.responseData.ResponseModelItem


@Database(entities = [ResponseModelItem::class],version = 1)
abstract class ActorRoomDatabase:RoomDatabase() {
    abstract fun getResponseDAO():ActorDAO

    companion object{
        private var INSTANCE:ActorRoomDatabase?=null
        fun getDatabseObject(context: Context):ActorRoomDatabase{
            if (INSTANCE==null){
                var builder=Room.databaseBuilder(context.applicationContext,ActorRoomDatabase::class.java,"actor_bd")
                builder.fallbackToDestructiveMigration()
                INSTANCE=builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }
}