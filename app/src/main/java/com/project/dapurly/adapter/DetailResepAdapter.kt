package com.project.dapurly.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dapurly.R
import com.project.dapurly.databinding.RowDetailResepBinding
import com.project.dapurly.model.DetailResepModel

class DetailResepAdapter(var list: List<DetailResepModel>) : RecyclerView.Adapter<DetailResepAdapter.RowDetailResepVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDetailResepVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_detail_resep, parent, false)
        return RowDetailResepVH(view)
    }

    override fun onBindViewHolder(holder: RowDetailResepVH, position: Int) {
        val detailResepModel = DetailResepModel()
    }

    override fun getItemCount(): Int = 2


    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: DetailResepModel
        ) {
        }
    }

    inner class RowDetailResepVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowDetailResepBinding = RowDetailResepBinding.bind(itemView)
    }
}
