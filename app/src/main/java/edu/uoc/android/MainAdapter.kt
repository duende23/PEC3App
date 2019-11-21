package edu.uoc.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.rest.MuseumService
import edu.uoc.android.rest.models.Element
import edu.uoc.android.rest.models.Museums
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter (val MyDataSet:MutableList<Element>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount()= MyDataSet.size
        //return 10


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CustomViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val museos = MyDataSet.get(position)
        holder.view.tv1.text = museos.adrecaNom

        //val museos = MyDataSet.get(position)
        //holder.view.tv1.text = "123"

        //val MyDataSet = MyDataSet[position]
        //holder.primero.text = MyDataSet.adrecaNom


    }
}

class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view)
//class CustomViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

 //   val primero : TextView = itemView.tv1
//}






