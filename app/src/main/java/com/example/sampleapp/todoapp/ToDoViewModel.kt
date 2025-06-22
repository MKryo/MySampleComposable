package com.example.sampleapp.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted


class ToDoViewModel: ViewModel() {

    private val toDoModel: ToDoModel = ToDoModel()
    private val toDoItems: MutableStateFlow<List<ToDoItem>?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            delay(300) // API呼び出しを想定
            toDoItems.value = toDoModel.loadToDoItems()
        }
    }

    val uiState: StateFlow<ToDoUiState> = toDoItems.map { toDoItems ->
        if (toDoItems == null) {
            ToDoUiState.Loading
        } else {
            ToDoUiState.Success(toDoItems = toDoItems)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ToDoUiState.Loading
    )
}