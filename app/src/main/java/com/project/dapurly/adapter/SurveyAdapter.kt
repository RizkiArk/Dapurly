package com.project.dapurly.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.dapurly.R
import com.project.dapurly.databinding.RowSurveyBinding
import com.project.dapurly.model.SurveyRowModel

class SurveyAdapter(var ctx: Context, val list: List<SurveyRowModel>) :
    RecyclerView.Adapter<SurveyAdapter.RowSurveyVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowSurveyVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_survey, parent, false)
        return RowSurveyVH(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: RowSurveyVH, pos: Int) {
        val item = list[pos]
        with(holder) {
            binding.txtName.text = item.name
            binding.imgvImage.setImageDrawable( ctx.resources.getDrawable(item.image as Int))

            binding.root.setOnClickListener {
                if (item.isSelected) {
                    item.isSelected = false
                    binding.root.background =
                        ctx.resources.getDrawable(R.drawable.rectangle_bg_gray_100_radius_8)
                } else {
                    item.isSelected = true
                    binding.root.background =
                        ctx.resources.getDrawable(R.drawable.rectangle_bg_gray_100_border_yellow_700_radius_8)
                }
                clickListener?.onItemClick(it, pos, SurveyRowModel())
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: SurveyRowModel
        ) {
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    inner class RowSurveyVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowSurveyBinding = RowSurveyBinding.bind(itemView)
    }
}
