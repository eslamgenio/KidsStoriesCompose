package com.example.mykidsstoriesn

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CounterButton() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text(text = "Count: $count")
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterButtonPreview() {
    CounterButton()
}
