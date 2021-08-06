package com.example.country_search_demo_app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Entity(tableName = "countries")
@Parcelize
data class CountryDetailsResponse(
    @SerializedName("name") val name: String,
    @SerializedName("topLevelDomain") val topLevelDomain: List<String>,
    @SerializedName("alpha2Code") val alpha2Code: String,
    @SerializedName("alpha3Code") val alpha3Code: String,
    @SerializedName("callingCodes") val callingCodes: List<String>,
    @SerializedName("capital") val capital: String,
    @SerializedName("altSpellings") val altSpellings: List<String>,
    @SerializedName("region") val region: String,
    @SerializedName("subregion") val subregion: String,
    @SerializedName("population") var population: Int,
    @SerializedName("latlng") val latlng: List<Double>,
    @SerializedName("demonym") val demonym: String,
    @SerializedName("area") val area: String?,
    @SerializedName("gini") val gini: String?,
    @SerializedName("timezones") val timezones: List<String>,
    @SerializedName("borders") val borders: List<String>,
    @SerializedName("nativeName") val nativeName: String,
    @SerializedName("numericCode") val numericCode: String,
    @SerializedName("currencies") val currencies: List<Currency>,
    @SerializedName("languages") val languages: List<Language>,
    @SerializedName("translations") val translations: Translations,
    @SerializedName("flag") val flag: String,
    @SerializedName("regionalBlocs") val regionalBlocs: List<RegionalBloc>,
    @SerializedName("cioc") val cioc: String
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}