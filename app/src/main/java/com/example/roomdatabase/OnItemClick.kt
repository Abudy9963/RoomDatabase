package com.example.roomdatabase

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.data.Person

interface OnItemClick {
    fun onClick(person: Person)
    fun onLongClick(person: Person, view: View)
}