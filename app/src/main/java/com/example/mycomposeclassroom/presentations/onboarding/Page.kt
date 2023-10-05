package com.example.mycomposeclassroom.presentations.onboarding

import androidx.annotation.DrawableRes
import com.example.mycomposeclassroom.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Neque porro quisquam",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
        image = R.drawable.ic_page_couple
    ),
    Page(
        title = "Lorem Ipsum are many",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
        image = R.drawable.ic_page_excercise
    ),
    Page(
        title = "There are many variations",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
        image = R.drawable.ic_page_girl
    )
)