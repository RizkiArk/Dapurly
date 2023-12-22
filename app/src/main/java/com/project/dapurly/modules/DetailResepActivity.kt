package com.project.dapurly.modules

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.adapter.DetailResepAdapter
import com.project.dapurly.adapter.ReviewAdapter
import com.project.dapurly.adapter.ResepAdapter
import com.project.dapurly.adapter.ResepRecomendAdapter
import com.project.dapurly.databinding.ActivityDetailResepBinding
import com.project.dapurly.model.ResepRowModel
import com.project.dapurly.model.ResepRecommendRowModel

class DetailResepActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailResepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = DetailResepAdapter(ArrayList())
        binding.rvData1.adapter = adapter1

        val adapter2 = ReviewAdapter(ArrayList())
        binding.rvData2.adapter = adapter2

        val adapter3 = ResepAdapter(ArrayList())
        adapter3.setOnItemClickListener(object :
            ResepAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRowModel
            ) {
                val intent = Intent(this@DetailResepActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })
        binding.rvData3.adapter = adapter3

        val adapter4 = ResepRecomendAdapter(ArrayList())
        adapter4.setOnItemClickListener(object : ResepRecomendAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRecommendRowModel
            ) {
                val intent = Intent(this@DetailResepActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })
        binding.rvData4.adapter = adapter4


        binding.btnBack.setOnClickListener { finish() }
    }
}
