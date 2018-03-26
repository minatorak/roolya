package com.app.minato.roolya.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.minato.roolya.R
import com.app.minato.roolya.model.MedicineModel
import kotlinx.android.synthetic.main.item_re.view.*

class DiseaseAdapter(val itemList: ArrayList<MedicineModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listener:ClickItem? = null

    fun setlistener(listtener_out: ClickItem) {
        listener = listtener_out
    }

    interface ClickItem {
        fun onClicklist(medicineModel: MedicineModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_re, parent, false)
        return DiseaseViewHoder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DiseaseViewHoder).bindData(itemList[position])
        holder.itemView.setOnClickListener {
            listener?.onClicklist(itemList[position])
        }
    }

    class DiseaseViewHoder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(item: MedicineModel) {
            itemView.textView.text = item.name
        }
    }

}