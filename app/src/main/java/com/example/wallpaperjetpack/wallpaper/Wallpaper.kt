package com.example.wallpaperjetpack.wallpaper

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wallpaperjetpack.R
import com.example.wallpaperjetpack.model.Category

@Composable
fun WallpaperScreen() {


    Column(modifier = Modifier.fillMaxSize()) {

        WallpaperList()
    }


}

@Composable
fun WallpaperList() {
    val categories = listOf(
        Category("Nature", R.drawable.splash_image),
        Category("City", R.drawable.splash_image),
        Category("Backgrounds", R.drawable.splash_image)
    )

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(categories)
            { categories ->
                WallpapersCardItem(category = categories) {
                }

            }
        }
    )
}


@Composable
fun WallpapersCardItem(category: Category, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomCenter, // Aligns the inner Box at the bottom
        modifier = Modifier
            .width(100.dp)
            .height(250.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = "Category Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        )

    }
}


@Preview(showBackground = true)

@Composable
fun previewWallapaper() {

    WallpaperScreen()

}