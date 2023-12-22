package com.project.dapurly.model

import com.project.dapurly.R
import kotlin.String

data class SurveyRowModel(
    var image: Any? = R.drawable.img_milk_off,
    var name: String? = "",
    var description: String? = "",
    var isSelected: Boolean = false
)

