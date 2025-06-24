package com.example.sampleapp.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sampleapp.data.BookmarkPreferences
import com.example.sampleapp.data.BookmarkRepository
import com.example.sampleapp.viewmodel.BookmarkViewModel
import com.example.sampleapp.viewmodel.BookmarkViewModelFactory


@Composable
fun BookmarkSwitch(context: Context) {
    val preferences = remember { BookmarkPreferences(context.applicationContext) }
    val repository = remember { BookmarkRepository(preferences) }
    val viewModel: BookmarkViewModel = viewModel(factory = BookmarkViewModelFactory(repository))

    val isBookmarked by viewModel.isBookmarked.collectAsState(initial = false)

    Column{
        Spacer(modifier = Modifier.padding(200.dp))
        Text("Bookmark Switch 練習")
        // Switch を使ってブックマークの状態をトグル
        Switch(
            checked = isBookmarked,
            onCheckedChange = {
                // 状態が変更されたら、viewModelに通知
                viewModel.toggleBookmark(it)
            }
        )
    }
}