package com.example.lab5.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab5.data.TaskRepository

class GeneralViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GeneralViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GeneralViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}