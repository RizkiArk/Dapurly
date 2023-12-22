package com.project.dapurly.model

data class InputPayload(
    val bahan_yang_disukai: List<String>,
    val bahan_yang_tidak_disukai: List<String>,
    val pantangan_makan: List<String>,
    val budget: Int,
    val jumlah_makan_sehari: Int,
    val jumlah_dewasa: Int,
    val jumlah_anak: Int,
    val country_references: String
)
