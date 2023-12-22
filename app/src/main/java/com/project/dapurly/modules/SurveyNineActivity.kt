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
import com.project.dapurly.adapter.SurveyNineAdapter
import com.project.dapurly.databinding.ActivitySurveyNineBinding
import com.project.dapurly.databinding.ActivitySurveySevenBinding
import com.project.dapurly.model.SurveyDataHolder

class SurveyNineActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveyNineBinding
    lateinit var recycleAdapter: SurveyNineAdapter
    lateinit var dataList: ArrayList<SurveyRowModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyNineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList = dataDummy()
        recycleAdapter = SurveyNineAdapter(this, dataList)
        recycleAdapter.setOnItemClickListener(object : SurveyNineAdapter.OnItemClickListener {
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
                SurveyDataHolder.saveAnswer("jumlah_makan_sehari", data.name ?: "", data.isSelected)
            }
            val intent = Intent(this@SurveyNineActivity, SurveyTenActivity::class.java)
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
        data1.name = "2 kali sehari"

        val data2 = SurveyRowModel()
        data2.name = "3 kali sehari"

        val data3 = SurveyRowModel()
        data3.name = "4 kali sehari"

        val data4 = SurveyRowModel()
        data4.name = "5 kali sehari atau lebih"



        dataTemp.add(data1)
        dataTemp.add(data2)
        dataTemp.add(data3)
        dataTemp.add(data4)

        return dataTemp;
    }
}