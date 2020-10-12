package com.example.roomdatabase.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repository(private val personDao: PersonDao) {



    val readAllData=personDao.getAll()
    suspend fun insert(person: Person){
        personDao.insertData(person)
    }

    suspend fun updata(person: Person){
        personDao.update(person)
    }

    suspend fun delete(person: Person){
        personDao.delete(person)
    }
}





