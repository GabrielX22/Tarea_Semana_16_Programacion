package com.example.tareasemana16programacion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    //Se crean las vairables privadas
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private var contactList = mutableListOf<Number>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //Se asigna un array
        contactList = ArrayList()
        //Se busca el ID y se asigna que es un Recyclerview
        recyclerView = findViewById(R.id.elrecycler) as RecyclerView
        //Se asigna el array que tendra el adaptador del recyclerview
        recyclerViewAdapter = RecyclerViewAdapter(contactList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        //El recyclerview y el layoutmanager se asigna
        recyclerView!!.layoutManager = layoutManager
        //Si se hace tap en cualquiera de los recyclerview, generara un toast que contiene el nombre del contacto
        recyclerViewAdapter!!.setOnItemClickListener(object : ClickListener<Number> {
            override fun onItemClick(data: Number) {
                //Un intent explicito cuando se quiere llamar al numero de cada recycler
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:"+data.num)
                startActivity(dialIntent)
            }
        })
        //Se le asigna el recyclerview su adaptador
        recyclerView!!.adapter = recyclerViewAdapter
        //Se llama a la funcion
        loscontactos()
    }
    //Se crea la funcion "loscontactos"
    private fun loscontactos(){
        //se crea una variable y se le asigna las variables que necesita por el Data Class
        var contact = Number("Juan",R.drawable.eljuan,"76092156")
        //Se agrega a la lista
        contactList.add(contact)
        contact = Number("Jose",R.drawable.eljose,"71237609")
        contactList.add(contact)
        contact = Number("Benito",R.drawable.bad,"77860093")
        contactList.add(contact)
        contact = Number("Andrea",R.drawable.andrea,"70223321")
        contactList.add(contact)
        contact = Number("Jennifer",R.drawable.jennifer,"74900911")
        contactList.add(contact)
        contact = Number("Jesus",R.drawable.jesus,"78822156")
        contactList.add(contact)
        //Se notifica al que los datos han sido cambiados
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}