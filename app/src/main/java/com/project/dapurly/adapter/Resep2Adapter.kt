package com.project.dapurly.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dapurly.R
import com.project.dapurly.databinding.RowResep2Binding
import com.project.dapurly.model.Resep2RowModel

class Resep2Adapter(var list: List<Resep2RowModel>) : RecyclerView.Adapter<Resep2Adapter.RowResep2VH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowResep2VH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_resep2, parent, false)
        return RowResep2VH(view)
    }

    override fun onBindViewHolder(holder: RowResep2VH, position: Int) {
        val resep2RowModel = Resep2RowModel()
    }

    override fun getItemCount(): Int = 2

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: Resep2RowModel
        ) {
        }
    }

    inner class RowResep2VH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding = RowResep2Binding.bind(itemView)
    }
}
