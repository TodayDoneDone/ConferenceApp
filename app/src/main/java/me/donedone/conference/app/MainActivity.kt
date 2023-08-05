package me.donedone.conference.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.donedone.conference.app.presentation.CardItem
import me.donedone.conference.app.ui.theme.Blue02
import me.donedone.conference.app.ui.theme.ConferenceAppTheme
import me.donedone.conference.app.ui.theme.Gray02
import me.donedone.conference.app.ui.theme.Gray03

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ConferenceAppTheme {

                val list = remember {
                    List(50) {
                        CardItem(
                            thumbnail = "https://cf.festa.io/img/2023-8-4/5beffbd8-9861-4e33-8d18-d504fdebad47.png",
                            contentDesc = "2024 성빈랜드 컨퍼런스 • 4월 13일",
                            location = "잠실 롯데월드타워",
                            date = "4월 13일",
                            heart = true
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(list) { card ->
                        CardItem(cardItem = card)
                    }
                }

            }
        }
    }
}

@Composable
fun CardItem(cardItem: CardItem) {
    Card(
        modifier = Modifier.padding(horizontal = 12.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Blue02,
        ),
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 8.dp)
                .width(312.dp)
                .height(176.dp)
                .clip(RoundedCornerShape(2.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(cardItem.thumbnail)
                .placeholder(R.drawable.ic_launcher_background)
                .build(),
            contentDescription = "conference image",
        )

        Layout(modifier = Modifier.fillMaxWidth(),
            content = {
                Text(
                    modifier = Modifier.layoutId("contentDesc"),
                    text = cardItem.contentDesc,
                    fontSize = 14.sp,
                    style = TextStyle(lineHeight = 18.sp),
                    fontWeight = FontWeight.W700,
                    color = Gray02
                )

                Icon(
                    modifier = Modifier.layoutId("locationIcon"),
                    painter = painterResource(R.drawable.location),
                    contentDescription = "location icon",
                    tint = Color.Unspecified
                )
                Text(
                    modifier = Modifier.layoutId("locationTxt"),
                    text = cardItem.location,
                    fontSize = 12.sp,
                    style = TextStyle(lineHeight = 14.4.sp),
                    fontWeight = FontWeight.W500,
                    color = Gray03,
                )
                Icon(
                    modifier = Modifier.layoutId("heartIcon"),
                    painter = if (cardItem.heart) painterResource(R.drawable.blue_heart) else painterResource(
                        R.drawable.empty_heart
                    ),
                    contentDescription = "empty heart icon",
                    tint = Color.Unspecified
                )
            }) { measurables, constraints ->

            val looseConstraint = constraints.copy(
                minWidth = 0
            )
            val contentDesc = measurables.first { it.layoutId == "contentDesc" }
            val contentDescPlaceable = contentDesc.measure(
                looseConstraint
            )

            val locationIcon = measurables.first { it.layoutId == "locationIcon" }
            val locationIconPlaceable = locationIcon.measure(
                looseConstraint
            )

            val locationTxt = measurables.first { it.layoutId == "locationTxt" }
            val locationTxtPlaceable = locationTxt.measure(
                looseConstraint
            )

            val heartIcon = measurables.first { it.layoutId == "heartIcon" }
            val heartIconPlaceable = heartIcon.measure(
                looseConstraint
            )

            val height =
                contentDescPlaceable.height + 4.dp.roundToPx() + locationIconPlaceable.height + 16.dp.roundToPx()
            val startPadding = 12.dp.roundToPx()
            layout(
                width = constraints.maxWidth,
                height = height
            ) {
                contentDescPlaceable.place(x = startPadding, y = 0)
                locationIconPlaceable.place(
                    x = startPadding,
                    y = contentDescPlaceable.height + 4.dp.roundToPx()
                )
                locationTxtPlaceable.place(
                    x = locationIconPlaceable.width + startPadding,
                    y = contentDescPlaceable.height + 4.dp.roundToPx()
                )
                heartIconPlaceable.place(
                    x = constraints.maxWidth - heartIconPlaceable.width - startPadding,
                    y = Alignment.CenterVertically.align(
                        size = heartIconPlaceable.height,
                        space = height - 16.dp.roundToPx()
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val card = CardItem(
        thumbnail = "https://cf.festa.io/img/2023-8-4/5beffbd8-9861-4e33-8d18-d504fdebad47.png",
        contentDesc = "2024 성빈랜드 컨퍼런스 • 4월 13일",
        location = "잠실 롯데월드타워",
        date = "4월 13일",
        heart = false
    )
    ConferenceAppTheme {
        CardItem(cardItem = card)

    }
}