package edu.uoc.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.android.rest.models.Element
import edu.uoc.android.rest.models.Museums
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {


    val museo = ArrayList<Element>()

    override fun getItemCount(): Int {
        return museo.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CustomViewHolder(layoutInflater)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val museos = museo.get(position)
        holder.view.tv1.text = museos.adrecaNom

    }


}

class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view)






