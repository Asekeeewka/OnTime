package com.example.ontime.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class RestaurantMenu(
        @SerializedName("data")
        @Expose
        val `data`: Data
) : Serializable{
    data class Data(
            @SerializedName("name")
            @Expose
            val name: String,
            @SerializedName("meals")
            @Expose
            val meals: List<Meal>
    ): Serializable {
        data class Meal(
                @SerializedName("name")
                @Expose
                val name: String,
                @SerializedName("price")
                @Expose
                val price: Int,
                @SerializedName("description")
                @Expose
                val description: String,
                @SerializedName("image")
                @Expose
                val image: String,
                @SerializedName("created_at")
                @Expose
                val createdAt: String,
                @SerializedName("updated_at")
                @Expose
                val updatedAt: String,
                var quantity: Int
        ): Serializable
    }
}