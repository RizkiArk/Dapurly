package com.project.dapurly.modules

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.project.dapurly.R
import com.project.dapurly.databinding.ActivitySurveyFourBinding
import com.project.dapurly.model.SurveyDataHolder

class SurveyFourActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurveyFourBinding

    lateinit var listDewasa: ArrayList<ImageView>
    lateinit var listAnak: ArrayList<ImageView>

    var catSelected = false
    var dogSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listDewasa = ArrayList()
        listAnak = ArrayList()

        listDewasa.add(binding.imgvDewasaOne)
        listDewasa.add(binding.imgvDewasaTwo)
        listDewasa.add(binding.imgvDewasaThree)
        listDewasa.add(binding.imgvDewasaFour)
        listDewasa.add(binding.imgvDewasaFive)

        listAnak.add(binding.imgvAnakOne)
        listAnak.add(binding.imgvAnakTwo)
        listAnak.add(binding.imgvAnakThree)
        listAnak.add(binding.imgvAnakFour)
        listAnak.add(binding.imgvAnakFive)
        
        binding.imgvPetOne.setOnClickListener {
            if(dogSelected){
                dogSelected = false
                binding.imgvPetOne.setColorFilter(ContextCompat.getColor(this, R.color.gray_300), android.graphics.PorterDuff.Mode.SRC_IN)
            }else {
                dogSelected = true
                binding.imgvPetOne.setColorFilter(ContextCompat.getColor(this, R.color.yellow_700), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }

        binding.imgvPetTwo.setOnClickListener {
            if(catSelected){
                catSelected = false
                binding.imgvPetTwo.setColorFilter(ContextCompat.getColor(this, R.color.gray_300), android.graphics.PorterDuff.Mode.SRC_IN)
            }else {
                catSelected = true
                binding.imgvPetTwo.setColorFilter(ContextCompat.getColor(this, R.color.yellow_700), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }

        binding.imgvDewasaOne.setOnClickListener {
            generateDewasa(0)
        }
        binding.imgvDewasaTwo.setOnClickListener {
            generateDewasa(1)
        }
        binding.imgvDewasaThree.setOnClickListener {
            generateDewasa(2)
        }
        binding.imgvDewasaFour.setOnClickListener {
            generateDewasa(3)
        }
        binding.imgvDewasaFive.setOnClickListener {
            generateDewasa(4)
        }

        binding.imgvAnakOne.setOnClickListener {
            generateAnak(0)
        }
        binding.imgvAnakTwo.setOnClickListener {
            generateAnak(1)
        }
        binding.imgvAnakThree.setOnClickListener {
            generateAnak(2)
        }
        binding.imgvAnakFour.setOnClickListener {
            generateAnak(3)
        }
        binding.imgvAnakFive.setOnClickListener {
            generateAnak(4)
        }

        binding.btnLanjut.setOnClickListener {
            SurveyDataHolder.jumlahDewasa = getSelectedAdultCount()
            SurveyDataHolder.jumlahAnak = getSelectedChildCount()
            val intent = Intent(this@SurveyFourActivity, SurveyOneActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getSelectedAdultCount(): Int {
        var count = 0
        for (i in 0 until 5) {
            if (listDewasa[i].colorFilter != null) {  // Jika warnanya bukan warna abu-abu (default)
                count++
            }
        }
        return count
    }

    private fun getSelectedChildCount(): Int {
        var count = 0
        for (i in 0 until 5) {
            if (listAnak[i].colorFilter != null) {
                count++
            }
        }
        return count
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun generateDewasa(index : Int){
        binding.btnLanjut.background = resources.getDrawable(R.drawable.rectangle_bg_yellow_700_radius_8)
        removeDewasaAll()
        for(i in index.downTo(0)){
            listDewasa[i].setColorFilter(ContextCompat.getColor(this, R.color.yellow_700), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

    fun removeDewasaAll(){
        for(i in 0..4){
            listDewasa[i].setColorFilter(ContextCompat.getColor(this, R.color.gray_300), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun generateAnak(index : Int){
        binding.btnLanjut.background = resources.getDrawable(R.drawable.rectangle_bg_yellow_700_radius_8)
        removeAnakAll()
        for(i in index.downTo(0)){
            listAnak[i].setColorFilter(ContextCompat.getColor(this, R.color.yellow_700), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

    fun removeAnakAll(){
        for(i in 0..4){
            listAnak[i].setColorFilter(ContextCompat.getColor(this, R.color.gray_300), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

}
