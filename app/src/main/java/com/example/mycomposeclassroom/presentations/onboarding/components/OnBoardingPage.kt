package com.example.mycomposeclassroom.presentations.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposeclassroom.R
import com.example.mycomposeclassroom.presentations.Dimens.MediumPadding16
import com.example.mycomposeclassroom.presentations.Dimens.MediumPadding24
import com.example.mycomposeclassroom.presentations.Dimens.MediumPadding30
import com.example.mycomposeclassroom.presentations.onboarding.Page
import com.example.mycomposeclassroom.presentations.onboarding.pages
import com.example.mycomposeclassroom.ui.theme.MyComposeClassRoomTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding24))
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding30),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Spacer(modifier = Modifier.height(MediumPadding16))
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding30),
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
        Spacer(modifier = Modifier.height(MediumPadding16))
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    MyComposeClassRoomTheme {
        OnBoardingPage(page = pages[0])
    }
}