package com.project.dapurly.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.project.dapurly.databinding.ActivitySurveyTwelveBinding
import com.project.dapurly.model.ApiService
import com.project.dapurly.model.InputPayload
import com.project.dapurly.model.SurveyDataHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SurveyTwelveActivity : AppCompatActivity() {

    lateinit var binding: ActivitySurveyTwelveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyTwelveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val edBudget = binding.edBudget
        val budgetValue: String = edBudget.text.toString()

        binding.btnLanjut.setOnClickListener {
            SurveyDataHolder.budget = 0
//            val intent = Intent(this@SurveyTwelveActivity, HomepageActivity::class.java)
//            startActivity(intent)
            val jumlMakan = SurveyDataHolder.surveyAnswers["jumlah_makan_sehari"]?.keys?.firstOrNull() ?: "0"

            val jumlahMakanSehari: Int = Regex("\\d+").find(jumlMakan)?.value?.toIntOrNull() ?: 0
//            val jumlahMakanSehari: Int = SurveyDataHolder.surveyAnswers["jumlah_makan_sehari"]?.keys?.firstOrNull()?.toInt() ?: 0
            val countryReferences: String = SurveyDataHolder.surveyAnswers["country_references"]?.keys?.firstOrNull() ?: ""

            val inputPayload = InputPayload(
                bahan_yang_disukai = SurveyDataHolder.surveyAnswers["bahan_yang_disukai"]?.keys?.toList() ?: emptyList(),
                bahan_yang_tidak_disukai = SurveyDataHolder.surveyAnswers["bahan_yang_tidak_disukai"]?.keys?.toList() ?: emptyList(),
                pantangan_makan = SurveyDataHolder.surveyAnswers["pantangan_makan"]?.keys?.toList() ?: emptyList(),
                budget = SurveyDataHolder.budget,
                jumlah_makan_sehari = jumlahMakanSehari,
                jumlah_dewasa = SurveyDataHolder.jumlahDewasa,
                jumlah_anak = SurveyDataHolder.jumlahAnak,
                country_references = countryReferences
            )

            sendSurveyDataToServer(inputPayload)
        }
    }

    private fun sendSurveyDataToServer(inputPayload: InputPayload) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dapurly-gj4jcbl5gq-et.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val call = apiService.sendSurveyData(inputPayload)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Handle response jika berhasil
                    val responseBody = response.body()
                    Log.d("Predict", "Response Body: $responseBody")
                    Toast.makeText(this@SurveyTwelveActivity, "Survey data sent successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SurveyTwelveActivity, HomepageActivity::class.java)
                    startActivity(intent)
                } else {
                    // Handle response jika gagal
                    // ...
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Handle kegagalan koneksi atau permintaan
                // ...
                Toast.makeText(this@SurveyTwelveActivity, "Survey data gagal terkirim: ${t.message}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SurveyTwelveActivity, HomepageActivity::class.java)
                startActivity(intent)
            }
        })
    }
}