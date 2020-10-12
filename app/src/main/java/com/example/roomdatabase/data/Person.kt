package com.example.roomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person_table")
class Person(
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    var firstName :String,
    var lastName:String,
    var age :Int
)