package com.project.dapurly.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dapurly.R
import com.project.dapurly.databinding.RowReviewBinding
import com.project.dapurly.model.ReviewRowModel

class ReviewAdapter(var list: List<ReviewRowModel>) :
    RecyclerView.Adapter<ReviewAdapter.RowReviewVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowReviewVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_review, parent, false)
        return RowReviewVH(view)
    }

    override fun onBindViewHolder(holder: RowReviewVH, position: Int) {
        val reviewRowModel = ReviewRowModel()
    }

    override fun getItemCount(): Int = 3

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: ReviewRowModel
        ) {
        }
    }

    inner class RowReviewVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowReviewBinding = RowReviewBinding.bind(itemView)
    }
}
