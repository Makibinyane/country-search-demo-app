package com.example.country_search_demo_app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "currency")
@Parcelize
data class Currency(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String
) : Parcelable {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
