package com.example.country_search_demo_app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "languages")
@Parcelize
data class Language(
    @SerializedName("iso639_1") val iso6391: String,
    @SerializedName("iso639_2") val iso6392: String,
    @SerializedName("name") var name: String,
    @SerializedName("nativeName") var nativeName: String
) : Parcelable {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
