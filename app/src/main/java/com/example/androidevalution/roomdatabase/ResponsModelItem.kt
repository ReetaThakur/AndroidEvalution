package com.example.androidevalution.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "actorDetails")
data class ResponsModelItem(@ColumnInfo(name = "actorName") var name:String){

}
