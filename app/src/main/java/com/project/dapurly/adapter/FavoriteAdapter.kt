package com.project.dapurly.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dapurly.R
import com.project.dapurly.databinding.RowFavoriteBinding
import com.project.dapurly.databinding.RowResepBinding
import com.project.dapurly.model.ResepRowModel

class FavoriteAdapter(
    var list: List<ResepRowModel>
) : RecyclerView.Adapter<FavoriteAdapter.RowResepVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RowResepVH {
        val
                view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_favorite, parent, false)
        return RowResepVH(view)
    }

    override fun onBindViewHolder(holder: RowResepVH, position: Int) {
        val resepRowModel = ResepRowModel()
    }

    override fun getItemCount(): Int = 3


    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: ResepRowModel
        ) {
        }
    }

    inner class RowResepVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding =
            RowFavoriteBinding.bind(itemView)

        init {
            binding.linearColumnicon.setOnClickListener {
                // TODO replace with value from datasource
                clickListener?.onItemClick(it, adapterPosition, ResepRowModel())
            }
        }
    }
}
