package com.project.dapurly.modules

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.R
import com.project.dapurly.adapter.ResepAdapter
import com.project.dapurly.adapter.ResepRecomendAdapter
import com.project.dapurly.adapter.SurveyAdapterElevan
import com.project.dapurly.databinding.ActivityHomepageBinding
import com.project.dapurly.model.ResepRowModel
import com.project.dapurly.model.ResepRecommendRowModel
import com.project.dapurly.model.SurveyRowModel

class HomepageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter1 = ResepAdapter(ArrayList())
        adapter1.setOnItemClickListener(object :
            ResepAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRowModel
            ) {
                val intent = Intent(this@HomepageActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })
        binding.rvData2.adapter = adapter1



        val adapter2 = ResepRecomendAdapter(ArrayList())
        val dummyData2 = dataDummy()

        adapter2.setOnItemClickListener(object : ResepRecomendAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRecommendRowModel
            ) {
                val intent = Intent(this@HomepageActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })
        binding.rvData1.adapter = adapter2

        binding.btnResep.setOnClickListener {
            val intent = Intent(this@HomepageActivity, ResepActivity::class.java)
            startActivity(intent)
        }

        binding.btnFavorite.setOnClickListener {
            val intent = Intent(this@HomepageActivity, FavoriteActivity::class.java)
            startActivity(intent)
        }

        binding.profile.setOnClickListener {
            val intent = Intent(this@HomepageActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
        adapter2.list = dataDummy()
        adapter2.notifyDataSetChanged()

    }


    fun dataDummy(): ArrayList<ResepRecommendRowModel> {
        val dataTemp: ArrayList<ResepRecommendRowModel> = ArrayList()
        val data1 = ResepRecommendRowModel()
        data1.label="pagi"
        data1.name = "Pizza"
        data1.price= 20000
        data1.image = R.drawable.img_rectangle142
        data1.tvTitleDes= "sadsdsdsd"
        data1.tvDescription= "sasdsdsdsdsdsdsdsdsdsdsdsds"
        dataTemp.add(data1)

        val data2 = ResepRecommendRowModel()
        data2.label="pagi"
        data2.name = "Pizza"
        data2.price= 20000
        data2.image = R.drawable.img_ayam
        data2.tvTitleDes= "sadsdsdsd"
        data2.tvDescription= "sasdsdsdsdsdsdsdsdsdsdsdsds"
        dataTemp.add(data2)


        return dataTemp;

    }
}