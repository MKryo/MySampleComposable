package com.example.sampleapp.todoapp

import kotlinx.coroutines.delay

class ToDoModel {
    suspend fun loadToDoItems(): List<ToDoItem> {
        delay(300)
        return FakeData.toDoItems
    }
}

private object FakeData {
    var toDoItems = listOf(
        ToDoItem(id = 1, title = "トイレ掃除", isCompleted = false),
        ToDoItem(id = 2, title = "排水溝掃除", isCompleted = true),
        ToDoItem(id = 3, title = "ゴミ捨て", isCompleted = false),
    )
}