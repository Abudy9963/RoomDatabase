package com.example.roomdatabase.data

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.Main2Activity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class PersonModel(application: Application):AndroidViewModel(application)  {



    val liveData:LiveData<List<Person>>
    private val repository:Repository
    init {

        val persond=PersonRoom.getInstence(application)?.personDao()
         repository= Repository(persond!!)
        liveData=repository.readAllData



    }

      fun inseert(person: Person){
         CoroutineScope(IO).launch {
             repository.insert(person)
             println("************Insert***************${Thread.currentThread().name}")
         }



    }
     fun update(person: Person){
         viewModelScope.launch (Dispatchers.IO){
            repository.updata(person)
            println("*************Update****************${Thread.currentThread().name}")
        }

    }
     fun delete(person: Person){
        viewModelScope.launch (Dispatchers.IO){
            repository.delete(person)
            println("*************Delete****************${Thread.currentThread().name}")
        }
    }












}