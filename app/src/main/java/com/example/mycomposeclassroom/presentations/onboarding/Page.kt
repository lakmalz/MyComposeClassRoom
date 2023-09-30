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
        description = "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain",
        image = R.drawable.ic_page_excercise
    ),
    Page(
        title = "There are many variations",
        description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old",
        image = R.drawable.ic_page_girl
    )
)