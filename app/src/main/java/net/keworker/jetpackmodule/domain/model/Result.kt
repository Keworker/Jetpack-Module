package net.keworker.jetpackmodule.domain.model

import java.time.LocalDateTime

data class Result(
    val id: Int,
    val answerCheckBox: String,
    val answerEditText: String,
    val answerRadio: String,
    val updateTime: LocalDateTime
)
