package com.example.sampleapp.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

object SettingsKeys {
    val IS_BOOKMARKED = booleanPreferencesKey("is_bookmarked")
}

class BookmarkPreferences(private val context: Context): BookmarkPreferencesInterface {

    override val isBookmarked: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[SettingsKeys.IS_BOOKMARKED] ?: false }

    override suspend fun setBookmarked(value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[SettingsKeys.IS_BOOKMARKED] = value
        }
    }
}