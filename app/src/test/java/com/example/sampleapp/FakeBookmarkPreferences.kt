package com.example.sampleapp

import com.example.sampleapp.data.BookmarkPreferencesInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeBookmarkPreferences: BookmarkPreferencesInterface {
    private val state = MutableStateFlow(false)

    override val isBookmarked: Flow<Boolean> = state

    override suspend fun setBookmarked(value: Boolean) {
        state.value = value
    }
}