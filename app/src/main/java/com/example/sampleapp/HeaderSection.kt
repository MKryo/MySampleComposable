package com.example.sampleapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // 適度な高さ
    ) {
        HeaderBackground()
        HeaderCopy()
        HeaderMenuButton()
    }
}

@Composable
fun HeaderBackground() {
    Image(
        painter = painterResource(id = R.drawable.header_image), // drawable に置いた画像
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}


@Composable
fun HeaderCopy(modifier: Modifier = Modifier) {
    // キャッチコピー
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Eat Where You Feel Home",
            style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
        )
        Text(
            text = "Enjoy the Moment. Eat Where You Feel Home. Eat Where You Feel Home.",
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
        )
    }
}


@Composable
fun HeaderMenuButton() {
    // ハンバーガーメニュー
    IconButton(
        onClick = { /* TODO: メニュー動作 */ },
        modifier = Modifier
            .padding(12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview(){
    HeaderSection()
}