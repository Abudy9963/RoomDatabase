package com.example.roomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.data.Person
import kotlinx.android.synthetic.main.row.view.*

class Adapter(val list :List<Person>,val context: Context,val onItemClick: OnItemClick) : RecyclerView.Adapter<Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return Holder(v)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val per=list[position]
        holder.firstTxt.text=per.firstName
        holder.ageText.text=per.age


        holder.card.setOnClickListener {
            onItemClick.onClick(per)
        }
        holder.card.setOnLongClickListener{
           onItemClick.onLongClick(per, holder.itemView)
             false
    }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val firstTxt=itemView.firstNameCard
    val ageText=itemView.ageNameCard
    val card =itemView.card



}
