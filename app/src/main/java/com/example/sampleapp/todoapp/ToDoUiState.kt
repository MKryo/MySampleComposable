package com.example.sampleapp.todoapp

sealed interface ToDoUiState {
    data object Loading: ToDoUiState

    data class Success(
        val toDoItems: List<ToDoItem>
    ): ToDoUiState

    data class Error(val message: String) : ToDoUiState

}