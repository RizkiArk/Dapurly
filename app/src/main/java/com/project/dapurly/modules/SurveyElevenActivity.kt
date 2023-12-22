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
import com.project.dapurly.databinding.ActivitySurveyElevenBinding
import com.project.dapurly.databinding.ActivitySurveyTenBinding
import com.project.dapurly.model.SurveyDataHolder

class SurveyElevenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveyElevenBinding
    lateinit var recycleAdapter: SurveyAdapterElevan
    lateinit var dataList: ArrayList<SurveyRowModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyElevenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList = dataDummy()
        recycleAdapter = SurveyAdapterElevan(this, dataList)
        recycleAdapter.setOnItemClickListener(object : SurveyAdapterElevan.OnItemClickListener {
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
                SurveyDataHolder.saveAnswer("country_references", data.name ?: "", data.isSelected)
            }
            val intent = Intent(this@SurveyElevenActivity, SurveyTwelveActivity::class.java)
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
        data1.image = R.drawable.amerika
        data1.name = "Amerika"

        val data2 = SurveyRowModel()
        data2.image = R.drawable.italia
        data2.name = "Italia"

        val data3 = SurveyRowModel()
        data3.image = R.drawable.france
        data3.name = "France"

        val data4 = SurveyRowModel()
        data4.image = R.drawable.france
        data4.name = "France"


        val data5 = SurveyRowModel()
        data5.image = R.drawable.canada
        data5.name = "Canada"


        val data6 = SurveyRowModel()
        data6.image = R.drawable.england
        data6.name = "England"

        val data7 = SurveyRowModel()
        data7.image = R.drawable.belgia
        data7.name = "Belgia"



        val data8 = SurveyRowModel()
        data8.image = R.drawable.mexico
        data8.name = "Mexico"



        val data9 = SurveyRowModel()
        data9.image = R.drawable.spain
        data9.name = "Spain"







        dataTemp.add(data1)
        dataTemp.add(data2)
        dataTemp.add(data3)
        dataTemp.add(data4)
        dataTemp.add(data5)
        dataTemp.add(data6)
        dataTemp.add(data7)
        dataTemp.add(data8)
        dataTemp.add(data9)



        return dataTemp;
    }
}