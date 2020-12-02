package com.example.roomdatabase

import android.app.Application
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.data.Person
import com.example.roomdatabase.data.PersonModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class FragmentList : Fragment() ,OnItemClick{
    lateinit var personModel: PersonModel

    lateinit var v :View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         v =inflater.inflate(R.layout.fragment_list, container, false)
       val add =v.findViewById<FloatingActionButton>(R.id.add)
        val recycler1=v.findViewById<RecyclerView>(R.id.recycler1)





      add.setOnClickListener {

          Navigation.findNavController(v).navigate(R.id.action_fragmentList_to_addFragment)

       }


        recycler1.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL,false)

        personModel= ViewModelProvider(this).get(PersonModel::class.java)

        personModel.liveData.observe(viewLifecycleOwner, Observer {
            if (container != null) {
                recycler1.adapter = Adapter(it, container.context, this)
            }
        })

 return v
    }

    override fun onClick(person: Person) {

        val b =Bundle()
        b.putString("firstName",person.firstName)
        b.putString("lastName",person.lastName)
        b.putString("age",person.age)
        b.putInt("id",person.id)



//        activity!!.supportFragmentManager.beginTransaction()
//            .replace(R.id.fram,addFragment)
//            .addToBackStack(null)
//            .commit()
        Navigation.findNavController(v).navigate(R.id.action_fragmentList_to_addFragment,b)




    }

    override fun onLongClick(person: Person, view: View) {
        val popupMenu = PopupMenu(view.context, view)
        popupMenu.inflate(R.menu.delete)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener {
            val dialog=Dialog(activity!!.applicationContext)

            personModel.delete(person)





            false
    }


}


}
