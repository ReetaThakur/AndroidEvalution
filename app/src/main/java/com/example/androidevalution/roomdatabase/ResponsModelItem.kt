package com.example.androidevalution.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "actorDetails")
data class ResponsModelItem(@ColumnInfo(name = "actorName") var name:String,
@ColumnInfo(name= "actorCountry") var country:String,
@ColumnInfo(name = "countryCode") var code:String,
@ColumnInfo(name = "birthDate")var birthdate:String,
@ColumnInfo(name = "deathdate")var deathdate:String){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id:Int?=null

}
