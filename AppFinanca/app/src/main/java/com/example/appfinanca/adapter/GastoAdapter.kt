package com.example.appfinanca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfinanca.OnClickedListener
import com.example.appfinanca.R
import com.example.appfinanca.model.GastoModel

class GastoAdapter(private val clickListener: OnClickedListener) :
    RecyclerView.Adapter<GastoAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var textView1: TextView
        init {
            textView1 = itemView.findViewById(R.id.textView1)
            itemView.setOnClickListener {
                clickListener.onItemClicked(it,adapterPosition)
            }
            itemView.setOnLongClickListener {
                clickListener.onItemLongClicked(it,adapterPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_card,
                parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val gasto = GastoModel.instance.gastos[position]
        holder.textView1.text = gasto.valor
    }
    override fun getItemCount(): Int {
        return GastoModel.instance.gastos.size
    }
}