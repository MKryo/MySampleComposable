package com.example.sampleapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchForm() {
    Column(modifier = Modifier.padding(16.dp)) {
        // ▼ ロケーション入力欄
        OutlinedTextField(
            value = "Japan",
            onValueChange = { /* TODO */ },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Location") },
            leadingIcon = {
                Icon(Icons.Default.LocationOn, contentDescription = "Location")
            },
            readOnly = true // いったん編集不可
        )
        Spacer(modifier = Modifier.height(12.dp))

        // ▼ 日付・時間・人数の横並び（実際はカスタム表示だが仮でテキストベースに）
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.DateRange, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Sat, Jun 14")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(4.dp))
                Text("19:00")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Person, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text("2 people")
            }
        }
    }
}