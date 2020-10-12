package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fragmentList=FragmentList()
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.fram,fragmentList)
            .commit()

    }


}
