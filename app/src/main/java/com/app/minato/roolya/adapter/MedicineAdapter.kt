package com.app.minato.roolya.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.minato.roolya.MedicineModel
import com.app.minato.roolya.R
import kotlinx.android.synthetic.main.list_item.view.*

class MedicineAdapter(val itemlist:ArrayList<MedicineModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as PartViewHolder).bind(itemlist[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PartViewHolder? {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun getItemCount() = itemlist.size


    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: MedicineModel) {
            itemView.tv_name.text = part.itemName
            itemView.tv_id.text = part.id
        }
    }
}