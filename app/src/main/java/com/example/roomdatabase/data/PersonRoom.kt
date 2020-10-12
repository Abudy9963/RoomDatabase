package com.example.roomdatabase.data

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

    @Database(entities = [Person::class],version = 1,exportSchema = false)
    abstract class PersonRoom : RoomDatabase() {
     abstract fun personDao(): PersonDao



            companion object{
            @Volatile
             var INSTENCE: PersonRoom? = null
            fun getInstence( context: Context): PersonRoom? {
                if (INSTENCE!=null){
                    return INSTENCE
                }
                else{
                    synchronized(this){
                        INSTENCE=Room.databaseBuilder(context.applicationContext,
                            PersonRoom::class.java,
                            "myDatabase")
                            .allowMainThreadQueries()
                            .build()
                        return  INSTENCE
                    }
                }

            }




        }
    }




