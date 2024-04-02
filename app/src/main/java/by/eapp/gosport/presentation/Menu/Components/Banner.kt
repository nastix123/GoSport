package by.eapp.gosport.presentation.Menu.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.eapp.gosport.R

@Composable
fun BannerRow() {
    LazyRow(
    ) {
        items(3) {
            Banner()
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun Banner() {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(100.dp),
        shape = RoundedCornerShape(15.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_banner),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun BannerPreview() {
    Banner()
}