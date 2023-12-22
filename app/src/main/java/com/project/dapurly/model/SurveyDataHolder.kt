package com.project.dapurly.model

object SurveyDataHolder {
    val surveyAnswers = mutableMapOf<String, MutableMap<String, Boolean>>()
    var selectedPeopleCount: Int = 0
    var isDogSelected: Boolean = false
    var isCatSelected: Boolean = false
    var jumlahDewasa: Int = 0
    var jumlahAnak: Int = 0
    var budget: Int = 0

    fun saveAnswer(category: String, question: String, answer: Boolean) {
        val categoryAnswers = surveyAnswers.getOrPut(category) { mutableMapOf() }
        categoryAnswers[question] = answer
    }

    fun getAnswer(category: String, question: String): Boolean {
        return surveyAnswers[category]?.get(question) ?: false
    }
}

