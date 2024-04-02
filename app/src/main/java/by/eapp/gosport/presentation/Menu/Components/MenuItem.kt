package by.eapp.gosport.presentation.Menu.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.eapp.gosport.R
import by.eapp.gosport.presentation.Menu.CustomText
import by.eapp.gosport.ui.theme.secondaryText
import coil.compose.AsyncImage

@Composable
fun MenuItem(
    title: String,
    price:String,
    description: List<String?>,
    imageUrl: String
) {
    val filteredDescription = description.filterNotNull().joinToString(", ")
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
    ) {
        Row() {
            Column {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                CustomText(
                    text = title,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                CustomText(
                    text = filteredDescription,
                    fontSize = 14,
                    color = secondaryText,
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}




