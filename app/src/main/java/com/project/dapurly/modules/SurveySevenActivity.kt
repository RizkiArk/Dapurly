package com.project.dapurly.modules

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.R
import com.project.dapurly.databinding.ActivitySurveySixBinding
import com.project.dapurly.model.SurveyRowModel
import com.project.dapurly.adapter.SurveyAdapter
import com.project.dapurly.adapter.SurveyAdapterlist
import com.project.dapurly.databinding.ActivitySurveySevenBinding
import com.project.dapurly.model.SurveyDataHolder

class SurveySevenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveySevenBinding
    lateinit var recycleAdapter: SurveyAdapterlist
    lateinit var dataList: ArrayList<SurveyRowModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList = dataDummy()
        recycleAdapter = SurveyAdapterlist(this, dataList)
        recycleAdapter.setOnItemClickListener(object : SurveyAdapterlist.OnItemClickListener {
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
            for (data in dataList) {
                SurveyDataHolder.saveAnswer("alat_masak", data.name ?: "", data.isSelected)
            }
            val intent = Intent(this@SurveySevenActivity, SurveyEightActivity::class.java)
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
        data1.name = "Bebas Susu"

        val data2 = SurveyRowModel()
        data2.name = "Bebas Gluten"

        val data3 = SurveyRowModel()
        data3.name = "Daging Babi"

        val data4 = SurveyRowModel()
        data4.name = "Vegan"

        val data5 = SurveyRowModel()
        data5.name = "Vegetarian"

        val data6 = SurveyRowModel()
        data6.name = "Vescatarian"

        dataTemp.add(data1)
        dataTemp.add(data2)
        dataTemp.add(data3)
        dataTemp.add(data4)
        dataTemp.add(data5)
        dataTemp.add(data6)

        return dataTemp;
    }
}