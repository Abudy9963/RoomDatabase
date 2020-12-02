package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.roomdatabase.data.Person
import com.example.roomdatabase.data.PersonModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddFragment : Fragment() {
    lateinit var personModel: PersonModel
    lateinit var firstNametxt:EditText
    lateinit var lastNametxt:EditText
    lateinit var agetxt:EditText
    lateinit var btnSave:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v =inflater.inflate(R.layout.fragment_add, container, false)
         firstNametxt=v.findViewById<EditText>(R.id.firstNametxt)
         lastNametxt=v.findViewById<EditText>(R.id.lastNametxt)
         agetxt=v.findViewById<EditText>(R.id.agetxt)
         btnSave=v.findViewById<Button>(R.id.btnSave)


        personModel= PersonModel(activity!!.application)
          var id :Int=0

        val b=arguments

        if (b!=null){
            var firstName=   b.getString("firstName")
            var lastName=  b.getString("lastName")
            var age= b.getString("age")
            id =  b.getInt("id")

            firstNametxt.setText(firstName)
            lastNametxt.setText(lastName)
            agetxt.setText(age)
            btnSave.setText("Update")



        }


        btnSave.setOnClickListener {

            var firstNamr = firstNametxt.text.toString()
            var lastName = lastNametxt.text.toString()
            var age = agetxt.text.toString()


            if (id==0) {


                var per = Person(0, firstNamr, lastName, age)

                    personModel.inseert(per)
                    println("debug :${Thread.currentThread().name}")




            }else{

                var per = Person(id, firstNamr, lastName, age)

                    personModel.update(per)





            }
           Navigation.findNavController(v).navigate(R.id.action_addFragment_to_fragmentList)
        }


 return v
    }



}
