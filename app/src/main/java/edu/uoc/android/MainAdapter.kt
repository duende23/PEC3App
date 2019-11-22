package edu.uoc.android

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.uoc.android.rest.ApiConstants
import edu.uoc.android.rest.MuseumService
import edu.uoc.android.rest.models.Element
import edu.uoc.android.rest.models.Museums
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter (val MyDataSet:MutableList<Element>) : RecyclerView.Adapter<CustomViewHolder>() {


    override fun getItemCount()= MyDataSet.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CustomViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val museos = MyDataSet.get(position)
        holder.view.tv1.text = museos.adrecaNom

        val thumbailImageView = holder.view.iv1
        Picasso.with(holder.view.context).load(museos.imatge[0]).into(thumbailImageView)


       //val MyDataSet = MyDataSet[position]
        //holder.tv1.text = MyDataSet.adrecaNom


        //val thumbailImageView = holder.itemView.iv1
        //Picasso.with(holder.itemView.context).load(MyDataSet.urlGeneral).into(thumbailImageView)


    }
}

class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view)
//class CustomViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

  // var tv1 : TextView = itemView.tv1
    //var iv1 : ImageView = itemView.iv1
//}






