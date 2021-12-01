package com.example.android.marsphotos.network
import com.squareup.moshi.Json

data class photoResposmodul(
    val error:Boolean, val msg:String, val data: List<ConntryPhoto>
)
data class ConntryPhoto (
    @Json(name="name") val name: String,
    @Json(name="flag") val flag: String)

