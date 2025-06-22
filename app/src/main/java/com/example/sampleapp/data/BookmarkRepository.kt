package com.example.sampleapp.data

class BookmarkRepository(
    private val preferences: BookmarkPreferences
) {
    fun getBookmarkState() = preferences.isBookmarked

    suspend fun setBookmarkState(bookmarked: Boolean) {
        preferences.setBookmarked(bookmarked)
    }
}