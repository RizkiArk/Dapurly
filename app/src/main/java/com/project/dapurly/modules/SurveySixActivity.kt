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
import com.project.dapurly.model.SurveyDataHolder

class SurveySixActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveySixBinding
    lateinit var recycleAdapter: SurveyAdapter
    lateinit var dataList: ArrayList<SurveyRowModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveySixBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList = dataDummy()
        recycleAdapter = SurveyAdapter(this, dataList)
        recycleAdapter.setOnItemClickListener(object : SurveyAdapter.OnItemClickListener {
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
                SurveyDataHolder.saveAnswer("pantangan_makan", data.name ?: "", data.isSelected)
            }
            val intent = Intent(this@SurveySixActivity, SurveySevenActivity::class.java)
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
        data1.image = R.drawable.img_milk_off;
        data1.name = "Bebas Susu"

        val data2 = SurveyRowModel()
        data2.image = R.drawable.img_gluten_off;
        data2.name = "Bebas Gluten"

        val data3 = SurveyRowModel()
        data3.image = R.drawable.img_pork_off;
        data3.name = "Daging Babi"

        val data4 = SurveyRowModel()
        data4.image = R.drawable.img_vegan_off;
        data4.name = "Vegan"

        val data5 = SurveyRowModel()
        data5.image = R.drawable.img_vegetarian_off;
        data5.name = "Vegetarian"

        val data6 = SurveyRowModel()
        data6.image = R.drawable.img_pescatarian_off;
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