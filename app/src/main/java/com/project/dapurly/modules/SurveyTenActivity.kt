package com.project.dapurly.modules

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.R
import com.project.dapurly.adapter.SurveyAdapterElevan
import com.project.dapurly.model.SurveyRowModel
import com.project.dapurly.adapter.SurveyAdapterTen
import com.project.dapurly.databinding.ActivitySurveyTenBinding
import com.project.dapurly.model.SurveyDataHolder

class SurveyTenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveyTenBinding
    lateinit var recycleAdapter: SurveyAdapterTen
    lateinit var dataList: ArrayList<SurveyRowModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyTenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList = dataDummy()
        recycleAdapter = SurveyAdapterTen(this, dataList)
        recycleAdapter.setOnItemClickListener(object : SurveyAdapterTen.OnItemClickListener {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onItemClick(view: View, position: Int, item: SurveyRowModel) {
                if (checkStatus()) {
                    binding.btnLanjut.background =
                        resources.getDrawable(R.drawable.rectangle_bg_yellow_700_radius_8)
                } else {
                    binding.btnLanjut.background =
                        resources.getDrawable(R.drawable.rectangle_bg_amber_200_radius_8)
                }
            }
        })
        binding.rvData.adapter = recycleAdapter

        binding.btnLanjut.setOnClickListener {
            val intent = Intent(this@SurveyTenActivity, SurveyElevenActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkStatus(): Boolean {
        for (d in dataList) {
            if (d.isSelected) {
                return true
            }
        }
        return false;
    }

    fun dataDummy(): ArrayList<SurveyRowModel> {
        val dataTemp: ArrayList<SurveyRowModel> = ArrayList()
        val data1 = SurveyRowModel()
        data1.image = R.drawable.img_milk_off
        data1.name = "Bebas Susu"
        data1.description = "Western food berasal dari Negara di wilayah Eropa dan Amerika"

        val data2 = SurveyRowModel()
        data2.image = R.drawable.img_milk_off
        data2.name = "Asian Food "
        data2.description = "Asian food berasal dari Negara di wilayah Asia"

        val data3 = SurveyRowModel()
        data3.image = R.drawable.img_milk_off
        data3.name = "Middle Eastern food"
        data3.description = "Middle Eastern food berasal dari Negara di wilayah Timur Tengah"




        dataTemp.add(data1)
        dataTemp.add(data2)
        dataTemp.add(data3)


        return dataTemp;
    }
}