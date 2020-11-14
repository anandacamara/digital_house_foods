package com.example.digitalhousefoods.domain

import java.io.Serializable

data class Restaurant(var name: String, var adress: String, var hour: String, var imageViewid: Int): Serializable {
}