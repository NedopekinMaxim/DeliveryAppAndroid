package com.example.deliveryappandroid

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deliveryappandroid.mainscreens.OnBoardingData
import com.example.deliveryappandroid.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(navController: NavController) {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.drawable.smile_star,
            MinorOrangeColor,
            "Вкусно и полезно!",
            "Мы предлагаем людям вкуснейшие блюда из натуральных продуктов лучшего качества"
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.rocket,
            MinorBlueColor,
            "Быстро!",
            "Среднее время доставки заказа — 1 час 6 минут." +
                    " Экспресс-заказы доставляем за 30 минут и даже быстрее "
        )
    )

    val pagerState = rememberPagerState(initialPage = 0)

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier.fillMaxWidth(),
        navController = navController
    )


}

@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = modifier) {
        Column(

        ) {
            HorizontalPager(count = 2, state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor)
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Image(
                        painter = painterResource(
                            id = item[page].image
                        ),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = item[page].tittle,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center,
                    )

                    Text(
                        text = item[page].info,
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(2.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(top = 30.dp)
                    ) {
                        repeat(item.size) {
                            Indicator(isSelected = it == currentPage, color = Color.White)
                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    if (currentPage == 1) {
                        Button(
                            onClick = { navController.navigate("AuthScreen") },
                            modifier = Modifier
                                .width(250.dp)
                                .height(60.dp),
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor)
                        ) {
                            Text(
                                text = "Начнем!",
                                style = MaterialTheme.typography.button
                            )
                        }
                    } else {
                        Button(
                            onClick = {
                                GlobalScope.launch {
                                    pagerState.scrollToPage(
                                        pagerState.currentPage + 1,
                                        pageOffset = 0f
                                    )
                                }
                            },
                            modifier = Modifier
                                .width(250.dp)
                                .height(60.dp),
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = BackgroundColor)
                        ) {
                            Text(
                                text = "Дальше",
                                style = MaterialTheme.typography.button,
                                color = TittleColor
                            )
                        }
                    }

                }
            }
        }

    }
}


@Composable
fun Indicator(isSelected: Boolean, color: Color) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) color else Color.Gray.copy(alpha = 0.5f)
            )
    )
}