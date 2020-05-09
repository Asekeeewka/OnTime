package com.example.ontime.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("data")
    @Expose
    val `data`: List<Data>
) {
    data class Data(
        @SerializedName("id")
        @Expose
        val id: Int,
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("work_time")
        @Expose
        val workTime: String,
        @SerializedName("created_at")
        @Expose
        val createdAt: String,
        @SerializedName("updated_at")
        @Expose
        val updatedAt: String,
        @SerializedName("menu")
        @Expose
        val menu: Int,
        @SerializedName("address")
        @Expose
        val address: Int
    )
}