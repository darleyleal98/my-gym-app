package com.darleyleal.mygym.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    primaryKeys = ["treinoId", "exercicioId"],
    foreignKeys = [ForeignKey(
        entity = Treino::class,
        parentColumns = ["id"],
        childColumns = ["treinoId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Exercicio(
    val treinoId: Int,
    @PrimaryKey(autoGenerate = true) val exercicioId: Int = 0,
    val nome: String,
    val series: Int,
    val repeticoes: Int,
    val carga: Int? = null,
    val observacoes: String? = null
)

