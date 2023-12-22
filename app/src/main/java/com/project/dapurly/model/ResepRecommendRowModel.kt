package com.project.dapurly.model

import com.project.dapurly.R

//
//data class ResepRecommendRowModel(
//    var txtGroupTwentySix: String? = "",
//    var txtArnoldPurnomo: String? = "",
//    var txtOlahanAyamKec: String? = ""
//)

data class ResepRecommendRowModel(
    var label: String? = "",
    var image: Int = 0,
    var name : String?= "",
    var tvTitleDes: String? = "",
    var price: Int? = null,
    var tvDescription: String? = "",
    )