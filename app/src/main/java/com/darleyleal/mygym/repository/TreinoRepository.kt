package com.darleyleal.mygym.repository

import com.darleyleal.mygym.model.Treino
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class TreinoRepository {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("treinos")

    suspend fun getAllTreinos(): List<Treino> {
        val snapshot = database.get().await()
        return snapshot.children.mapNotNull { it.getValue(Treino::class.java) }
    }

    suspend fun getTreinoById(treinoId: String): Treino? {
        val snapshot = database.child(treinoId).get().await()
        return snapshot.getValue(Treino::class.java)
    }

    suspend fun insertTreino(treino: Treino) {
        database.push().setValue(treino).await()
    }

    suspend fun updateTreino(treino: Treino) {
        database.child(treino.id.toString()).setValue(treino).await()
    }

    suspend fun deleteTreino(treinoId: String) {
        database.child(treinoId).removeValue().await()
    }
}
