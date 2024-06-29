package com.example.kidsstoriscompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kidsstoriscompose.ui.theme.KidsStorisComposeTheme

@Composable
fun StoryScreen(storyId: Int, navController: NavController?) {
    val storyPages = getStoryPages(storyId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn {
            items(storyPages) { page ->
                StoryPageView(page)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController?.navigateUp() }) {
            Text(text = "Back")
        }
    }
}

@Composable
fun StoryPageView(page: StoryPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = page.imageResId),
            contentDescription = "Story Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = page.text)
        Spacer(modifier = Modifier.height(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.speaker), // Assume you have a speaker icon in drawable
            contentDescription = "Play Audio",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    // Handle play audio action here
                },
            tint = Color.Black
        )
    }
}

fun getStoryPages(storyId: Int): List<StoryPage> {
    return when (storyId) {
        1 -> listOf(
            StoryPage(1, "This is the first page of Story 1.", R.drawable.s1p1),
            StoryPage(2, "This is the second page of Story 1.", R.drawable.s1p2)
        )
        2 -> listOf(
            StoryPage(1, "This is the first page of Story 2.", R.drawable.s2p1),
            StoryPage(2, "This is the second page of Story 2.", R.drawable.s2p2)
        )
        else -> emptyList()
    }
}

@Preview(showBackground = true)
@Composable
fun StoryScreenPreview() {
    KidsStorisComposeTheme {
        StoryScreen(storyId = 1, navController = null)
    }
}
