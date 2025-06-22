package com.example.sampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.data.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BookmarkViewModel(
    private val repository: BookmarkRepository
): ViewModel() {
    val isBookmarked: Flow<Boolean> = repository.getBookmarkState()

    fun toggleBookmark(value: Boolean) {
        viewModelScope.launch {
            repository.setBookmarkState(value)
        }
    }
}

class BookmarkViewModelFactory(private val repository: BookmarkRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookmarkViewModel(repository) as T
    }
}
