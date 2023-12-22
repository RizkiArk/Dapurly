package com.project.dapurly.modules

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.dapurly.databinding.ActivitySurveysBinding

class SurveysActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveysBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveysBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIsiSurvei.setOnClickListener {
            val intent = Intent(this@SurveysActivity, SurveyFourActivity::class.java)
            startActivity(intent)
        }

    }

}