package com.example.wallpaperjetpack.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpaperjetpack.R
import com.example.wallpaperjetpack.model.Category

@Composable
fun HomeScreen(

) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .background(color = colorResource(id = R.color.black))
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.lightBlack))
        ) {

            Text(

                textAlign = TextAlign.Center,
                text = "Home", color = Color.White, fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif


            )
        }

        CategoryListScreen()
    }


}


@Composable
fun CategoryListScreen() {
    val categories = listOf(
        Category("Nature", R.drawable.splash_image),
        Category("City", R.drawable.splash_image),
        Category("Backgrounds", R.drawable.splash_image)
    )

    LazyVerticalStaggeredGrid(

        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(categories) { category ->
                CategoryItem(category = category) {
                    // Navigate or handle click action here
//                    navController.navigate("detail_screen/${category.name}")
                }
            }
        }
    )
}

@Composable
fun CategoryItem(category: Category, onClick: () -> Unit) {
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

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    color = colorResource(id = R.color.black_fade),
                    shape = RoundedCornerShape(
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
        ) {
            Text(
                text = category.name,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun preView() {
//    CategoryItem(category = Category("jasjasj", R.drawable.splash_image))
    HomeScreen()
}




