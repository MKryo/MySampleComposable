package com.example.sampleapp.data

import kotlinx.coroutines.flow.Flow

interface BookmarkPreferencesInterface {
    val isBookmarked: Flow<Boolean>

    suspend fun setBookmarked(value: Boolean)
}