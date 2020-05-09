package com.example.ontime.network

import com.example.ontime.data.Restaurant
import com.example.ontime.data.RestaurantMenu
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @GET("api/v1/service/restaurants/list/")
    fun getRestaurants(): Observable<Response<Restaurant>>

    @GET("api/v1/service/restaurant/menu/")
    fun getRestaurantsMenu(
            @Query("restaurant_id") restaurant_id: String
    ): Observable<Response<RestaurantMenu>>
    //Это примеры на POST запросы
//    @POST("payments/cloudpayments/pay/charge-no-saved-card/{order_id}/")
//    fun payWithNoSavedCard(
//            @Header("Authorization") auth: String,
//            @Path("order_id") order_id: String,
//            @Body checkout: Checkout
//    ): Observable<Response<PaymentResult>>
//
//    @POST("payments/cloudpayments/pay/charge-with-saved-card/{order_id}/")
//    fun payWithSavedCard(
//            @Header("Authorization") auth: String,
//            @Path("order_id") order_id: String,
//            @Body cardID: CardID
//    ): Observable<Response<PaymentResult>>
//
//    @POST("payments/cloudpayments/pay/mobile-3d-secure-confirm/")
//    fun threeDSFinish(
//            @Header("Authorization") auth: String,
//            @Body threeDSFinish: ThreeDSFinish
//    ): Observable<Response<ResponseBody>>
}