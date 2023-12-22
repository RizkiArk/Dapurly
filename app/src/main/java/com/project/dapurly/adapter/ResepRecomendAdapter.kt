package com.project.dapurly.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dapurly.R
import com.project.dapurly.databinding.RowCardHomeBinding
import com.project.dapurly.databinding.RowResepRecommendBinding
import com.project.dapurly.model.ResepRecommendRowModel

class ResepRecomendAdapter(
    var list: List<ResepRecommendRowModel>
) : RecyclerView.Adapter<ResepRecomendAdapter.RowResepRecommendVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RowResepRecommendVH {
        val
                view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_card_home, parent, false)
        return RowResepRecommendVH(view)
    }

    override fun onBindViewHolder(holder: RowResepRecommendVH, position: Int) {
        val resepRecommendRowModel = list[position]

        // Bind your data to the views in your ViewHolder
        holder.binding.imageRectangleTwentyFive.setImageResource(resepRecommendRowModel.image)
        holder.binding.name.text = resepRecommendRowModel.name
        holder.binding.label.text = resepRecommendRowModel.label
        holder.binding.price.text = resepRecommendRowModel.price.toString()
        holder.binding.tvTitleDes.text= resepRecommendRowModel.tvTitleDes
        holder.binding.tvDescription.text= resepRecommendRowModel.tvDescription





    }

    override fun getItemCount(): Int = list.size
    // TODO uncomment following line after integration with data source

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: ResepRecommendRowModel
        ) {

        }
    }

    inner class RowResepRecommendVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding =
            RowCardHomeBinding.bind(itemView)

        init {
            binding.root.setOnClickListener {
                // TODO replace with value from datasource
                clickListener?.onItemClick(it, adapterPosition, list[adapterPosition])
            }
        }
    }
}
