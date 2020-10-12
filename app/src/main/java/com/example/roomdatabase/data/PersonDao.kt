package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface PersonDao {

    @Insert
     suspend fun insertData(person: Person)


    @Query("SELECT * FROM person_table")
    fun getAll(): LiveData<List<Person>>

    @Update
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)




}