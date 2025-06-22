package com.example.sampleapp

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun BookmarkSwitch(context: Context) {
    val scope = rememberCoroutineScope()
    val isBookmarked by getBookmarkState(context).collectAsState(initial = false)

    Column{
        Spacer(modifier = Modifier.padding(200.dp))
        Text("Bookmark Switch 練習")
        // Switch を使ってブックマークの状態をトグル
        Switch(
            checked = isBookmarked,
            onCheckedChange = {
                // 状態が変更されたら、DataStore に保存
                scope.launch {
                    saveBookmarkState(context, it)
                }
            }
        )
    }
}