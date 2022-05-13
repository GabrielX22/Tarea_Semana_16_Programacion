package com.example.tareasemana16programacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//Se hace un metodo constructor, el cual tiene una variable que hace la lisatde contactos
class RecyclerViewAdapter constructor(private val contactlist: List<Number>) :
RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
    //Se hace una variable privada para el ClickListener
    private var clickListener: ClickListener<Number>? = null
    //Se crea una funcion que crea un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        //Se infla con los valores y con la plantilla del recyclerview
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerviewlayout, parent,false)
        return MyViewHolder(view)
    }

    //En esta funcion se rellena con las variables y pasa por el púente de la data clase
    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        //Se crea una variable para conocer la posicion en la Lista
        val contact = contactlist[position]
        holder.name.text = contact.titulo
        //Se asigna la imagen de fondo
        holder.image.setBackgroundResource(contact.image)
        //cuando se de click en el cardview se accionara el clicklistener que es cada ves que se oprima un item
        holder.cardView.setOnClickListener {
            clickListener!!.onItemClick(contact)
        }
        holder.txtnum.text = "Numero: ${contact.num}"
    }
    //Esta funcion retorna el tamaño de la lista
    override fun getItemCount(): Int {
        return contactlist.size
    }
    //Cuando se oprima un recyclerview se accionara este bloque de codigo
fun setOnItemClickListener(numClickListener: ClickListener<Number>?){
    clickListener = numClickListener
}
    //Una clase interna que crean variables y se les llama por su ID en el layout
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.elnombre)
        val image: ImageView = itemView.findViewById(R.id.imagepersona)
        val cardView: CardView = itemView.findViewById(R.id.carView)
        val txtnum: TextView = itemView.findViewById(R.id.txtnum)
    }
}
//Una interfaz para usar el ClickListener
interface ClickListener<T> {
    fun onItemClick(data: T)
}