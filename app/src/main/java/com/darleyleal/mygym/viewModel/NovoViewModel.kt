package com.darleyleal.mygym.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darleyleal.mygym.model.Treino
import com.darleyleal.mygym.repository.TreinoRepository
import kotlinx.coroutines.launch

class NovoViewModel() : ViewModel() {

    private val repository = TreinoRepository()

    private val _treinos = MutableLiveData<List<Treino>>()
    val treinos: LiveData<List<Treino>> = _treinos

    fun getAllTreinos() = viewModelScope.launch {
        _treinos.value = repository.getAllTreinos()
    }

    fun getTreinoById(treinoId: String) = viewModelScope.launch {
        repository.getTreinoById(treinoId)
    }

    fun insertTreino(treino: Treino) = viewModelScope.launch {
        repository.insertTreino(treino)
    }

    fun updateTreino(treino: Treino) = viewModelScope.launch {
        repository.updateTreino(treino)
    }

    fun deleteTreino(treinoId: String) = viewModelScope.launch {
        repository.deleteTreino(treinoId)
    }
}