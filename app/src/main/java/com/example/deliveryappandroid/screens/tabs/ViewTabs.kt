package com.example.deliveryappandroid.screens.tabs

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.SecondaryColor
import com.example.deliveryappandroid.ui.theme.TittleColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<TabDish>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        modifier = Modifier.height(60.dp) ,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = BackgroundColor,
        contentColor = TittleColor,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(
                    "${tab.title}", color = TittleColor
                ) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabDish>, pagerState: PagerState) {
    HorizontalPager(count = 4, state = pagerState) { page ->
        tabs[page].screen()
    }
}


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        TabDish.Dishes,
        TabDish.Sauces,
        TabDish.Snacks,
        TabDish.Drinks
    )
    val pagerState = rememberPagerState()
    TabsContent(tabs = tabs, pagerState = pagerState)
}