package com.darleyleal.mygym.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darleyleal.mygym.model.Exercicio
import com.darleyleal.mygym.repository.ExercicioRepository
import kotlinx.coroutines.launch

class NovoExercicioViewModel() : ViewModel() {

    private val repository = ExercicioRepository()

    private val _exercicios = MutableLiveData<List<Exercicio>>()
    private val exercicios: LiveData<List<Exercicio>> = _exercicios

    private val _exercicio = MutableLiveData<Exercicio>()
    private val exercicio: LiveData<Exercicio> = _exercicio

    fun getExercicio(): LiveData<Exercicio> {
        return exercicio
    }

    fun getExerciciosByTreinoId(treinoId: String) = viewModelScope.launch {
        _exercicios.value = repository.getExerciciosByTreinoId(treinoId)
    }

    fun insertExercicio(exercicio: Exercicio) = viewModelScope.launch {
        repository.insertExercicio(exercicio)
    }

    fun updateExercicio(exercicio: Exercicio) = viewModelScope.launch {
        repository.updateExercicio(exercicio)
    }

    fun deleteExercicio(exercicioId: String) = viewModelScope.launch {
        repository.deleteExercicio(exercicioId)
    }
}
