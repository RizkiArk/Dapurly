package com.project.dapurly.modules

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.R
import com.project.dapurly.databinding.ActivitySurveyFiveBinding
import com.project.dapurly.model.SurveyRowModel
import com.project.dapurly.adapter.SurveyAdapter
import com.project.dapurly.model.SurveyDataHolder

class SurveyFiveActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveyFiveBinding
    lateinit var recycleAdapter: SurveyAdapter

    lateinit var dataList: ArrayList<SurveyRowModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyFiveBinding.inflate(layoutInflater)
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
                SurveyDataHolder.saveAnswer("bahan_yang_tidak_disukai", data.name ?: "", data.isSelected)
            }
            val intent = Intent(this@SurveyFiveActivity, SurveySixActivity::class.java)
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
        data1.image = R.drawable.img_keju;
        data1.name = "Keju"

        val data2 = SurveyRowModel()
        data2.image = R.drawable.img_nasi;
        data2.name = "Nasi"

        val data3 = SurveyRowModel()
        data3.image = R.drawable.img_bayam;
        data3.name = "Bayam"

        val data4 = SurveyRowModel()
        data4.image = R.drawable.img_daging_sapi;
        data4.name = "Daging Sapi"

        val data5 = SurveyRowModel()
        data5.image = R.drawable.img_jamur;
        data5.name = "Jamur"

        val data6 = SurveyRowModel()
        data6.image = R.drawable.img_terong;
        data6.name = "Terong"

        val data7 = SurveyRowModel()
        data7.image = R.drawable.img_ayam;
        data7.name = "Ayam"

        val data8 = SurveyRowModel()
        data8.image = R.drawable.img_susu;
        data8.name = "Susu"

        val data9 = SurveyRowModel()
        data9.image = R.drawable.img_telur;
        data9.name = "Telur"

        val data10 = SurveyRowModel()
        data10.image = R.drawable.img_tomat;
        data10.name = "Tomat"

        val data11 = SurveyRowModel()
        data11.image = R.drawable.img_jahe;
        data11.name = "Jahe"

        val data12 = SurveyRowModel()
        data12.image = R.drawable.img_kentang;
        data12.name = "Kentang"

        dataTemp.add(data1)
        dataTemp.add(data2)
        dataTemp.add(data3)
        dataTemp.add(data4)
        dataTemp.add(data5)
        dataTemp.add(data6)
        dataTemp.add(data7)
        dataTemp.add(data8)
        dataTemp.add(data9)
        dataTemp.add(data10)
        dataTemp.add(data11)
        dataTemp.add(data12)

        return dataTemp;
    }
}