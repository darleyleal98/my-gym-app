package com.darleyleal.mygym.repository

import com.darleyleal.mygym.model.Exercicio
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class ExercicioRepository {
    private val database: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("exercicios")

    suspend fun getExerciciosByTreinoId(treinoId: String): List<Exercicio> {
        val snapshot = database.child(treinoId).get().await()
        return snapshot.children.mapNotNull { it.getValue(Exercicio::class.java) }
    }

    suspend fun insertExercicio(exercicio: Exercicio) {
        database.child(exercicio.treinoId.toString()).push().setValue(exercicio).await()
    }

    suspend fun updateExercicio(exercicio: Exercicio) {
        database.child(exercicio.treinoId.toString()).child(
            exercicio.exercicioId.toString()
        ).setValue(exercicio).await()
    }

    suspend fun deleteExercicio(exercicioId: String) {
        database.child(exercicioId).removeValue().await()
    }
}