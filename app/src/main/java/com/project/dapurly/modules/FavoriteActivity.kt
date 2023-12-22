package com.project.dapurly.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project.dapurly.R
import com.project.dapurly.adapter.FavoriteAdapter
import com.project.dapurly.adapter.Resep2Adapter
import com.project.dapurly.adapter.ResepAdapter
import com.project.dapurly.adapter.ResepRecomendAdapter
import com.project.dapurly.databinding.ActivityFavoriteBinding
import com.project.dapurly.databinding.ActivityHomepageBinding
import com.project.dapurly.model.ResepRecommendRowModel
import com.project.dapurly.model.ResepRowModel

class FavoriteActivity : AppCompatActivity() {
    lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val FavoriteAdapter = FavoriteAdapter(ArrayList())
        FavoriteAdapter.setOnItemClickListener(object :
            FavoriteAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRowModel
            ) {
                val intent = Intent(this@FavoriteActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })
        binding.rvData1.adapter = FavoriteAdapter

        val adapter2 = ResepRecomendAdapter(ArrayList())
        adapter2.setOnItemClickListener(object : ResepRecomendAdapter.OnItemClickListener {
            override fun onItemClick(
                view: View,
                position: Int,
                item: ResepRecommendRowModel
            ) {
                val intent = Intent(this@FavoriteActivity, DetailResepActivity::class.java)
                startActivity(intent)
            }
        })

    }

}
