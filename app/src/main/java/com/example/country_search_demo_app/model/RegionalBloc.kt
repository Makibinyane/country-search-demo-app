package com.example.country_search_demo_app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "regionalBloc")
@Parcelize
data class RegionalBloc(
    @SerializedName("acronym") val acronym: String,
    @SerializedName("name") val name: String,
    @SerializedName("otherAcronyms") val otherAcronyms: List<String>,
    @SerializedName("otherNames") val otherNames: List<String>
) : Parcelable {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}