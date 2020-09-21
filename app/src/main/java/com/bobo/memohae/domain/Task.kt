package com.bobo.memohae.domain

data class Task(
    val id: String = "",
    var folder: String = "",
    var content: String,
    var isDeleted: Boolean = false
)