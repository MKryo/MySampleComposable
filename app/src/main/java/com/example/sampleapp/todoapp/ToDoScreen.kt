package com.example.sampleapp.todoapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ToDoScreen(
    uiState: ToDoUiState
) {
    Column {
        Text("TODOリスト")
        when (uiState) {
            ToDoUiState.Loading -> Text("読み込み中...")
            is ToDoUiState.Success -> Text("成功")
            is ToDoUiState.Error -> Text("エラー")
        }
    }
}