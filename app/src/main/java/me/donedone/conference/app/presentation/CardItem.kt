package me.donedone.conference.app.presentation

data class CardItem(
    val thumbnail: String,
    val contentDesc: String,
    val location: String,
    val date: String,
    val heart: Boolean = false
)
