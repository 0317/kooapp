package com.akash.kooapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akash.kooapp.R
import com.akash.kooapp.model.home.HomeDataModel
import java.util.*

class HomeAdapter(val context: Context, val postList: ArrayList<HomeDataModel>) :
        RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_home, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(postList[position], position, context)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(list: HomeDataModel, position: Int, context: Context) {
            var title: TextView = itemView.findViewById(R.id.titleText)
            var decsription: TextView = itemView.findViewById(R.id.descText)

            title.text = list.title
            decsription.text = list.body
        }
    }
}