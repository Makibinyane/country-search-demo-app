package com.example.country_search_demo_app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "translations")
@Parcelize
data class Translations(
    @SerializedName("de") val de: String,
    @SerializedName("es") val es: String,
    @SerializedName("fr") val fr: String,
    @SerializedName("ja") var ja: String,
    @SerializedName("it") val it: String,
    @SerializedName("br") val br: String,
    @SerializedName("pt") val pt: String,
    @SerializedName("nl") val nl: String,
    @SerializedName("hr") val hr: String,
    @SerializedName("fa") val fa: String
) : Parcelable {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}