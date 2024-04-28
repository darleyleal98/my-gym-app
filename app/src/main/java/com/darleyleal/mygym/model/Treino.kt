package com.darleyleal.mygym.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Treino (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val data: LocalDate
)
