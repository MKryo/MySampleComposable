package com.example.sampleapp

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

suspend fun saveBookmarkState(context: Context, isBookmarked: Boolean) {
    context.dataStore.edit { preferences ->
        preferences[SettingsKeys.IS_BOOKMARKED] = isBookmarked
    }
}

fun getBookmarkState(context: Context): Flow<Boolean> {
    return context.dataStore.data
        .map { preferences ->
            preferences[SettingsKeys.IS_BOOKMARKED] ?: false
        }
}