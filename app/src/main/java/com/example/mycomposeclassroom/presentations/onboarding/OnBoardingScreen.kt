package com.example.mycomposeclassroom.presentations.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mycomposeclassroom.presentations.Dimens.MediumPadding16
import com.example.mycomposeclassroom.presentations.Dimens.MediumPadding30
import com.example.mycomposeclassroom.presentations.common.NewsButton
import com.example.mycomposeclassroom.presentations.common.NewsTextButton
import com.example.mycomposeclassroom.presentations.onboarding.components.OnBoardingPage
import com.example.mycomposeclassroom.presentations.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0)

        HorizontalPager(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            state = pagerState,
            pageCount = pages.size
        ) { index ->
            OnBoardingPage(page = pages[index], modifier = Modifier.fillMaxSize())
        }
//        Spacer(modifier = Modifier.weight(1f))
        OnboardBottomActionButtons(pagerState)
        Spacer(modifier = Modifier.height(MediumPadding16))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardBottomActionButtons(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MediumPadding30)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val buttonsState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Next")
                    else -> listOf("", "")
                }
            }
        }

        PageIndicator(
            pageSize = pages.size,
            selectedPage = pagerState.currentPage
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            val scope = rememberCoroutineScope()
            if (buttonsState.value[0].isNotEmpty()) {
                NewsTextButton(text = buttonsState.value[0], onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage - 1
                        )
                    }
                })
            }

            NewsButton(text = buttonsState.value[1], onClick = {
                scope.launch {
                    if (pagerState.currentPage == 3) {
                        // Navigate to the main screen
                    } else {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1
                        )
                    }
                }
            })
        }
    }
}
