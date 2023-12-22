package com.project.dapurly.modules

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.adapter.Resep2Adapter
import com.project.dapurly.databinding.ActivityResepBinding
import com.project.dapurly.model.ResepRowModel
import com.project.dapurly.model.ResepRecommendRowModel
import com.project.dapurly.adapter.ResepAdapter
import com.project.dapurly.adapter.ResepRecomendAdapter

class ResepActivity : AppCompatActivity() {
    lateinit var binding: ActivityResepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ResepAdapter(ArrayList())
        adapter1.setOnItemClickListener(object :
            ResepAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRowModel
            ) {
                val intent = Intent(this@ResepActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })
        binding.rvData2.adapter = adapter1

        val adapter2 = ResepRecomendAdapter(ArrayList())
        adapter2.setOnItemClickListener(object : ResepRecomendAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRecommendRowModel
            ) {
                val intent = Intent(this@ResepActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })

        binding.rvData1.adapter = adapter2
        val adapter3 = Resep2Adapter(ArrayList())
        binding.rvData3.adapter = adapter3

        binding.btnHome.setOnClickListener {
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
        }
    }

}
