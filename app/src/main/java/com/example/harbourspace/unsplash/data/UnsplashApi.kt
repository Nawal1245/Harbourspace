package com.example.harbourspace.unsplash.data

import com.example.harbourspace.unsplash.model.PhotoDetails
import com.example.harbourspace.unsplash.model.UnsplashItem
import com.example.harbourspace.unsplash.model.UnsplashSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "zi-TYuGc4juUoaEBZ46kkfZ-dHQGKvicqDwyQji_hRI"

interface UnsplashAPIClient {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos() : Call<List<UnsplashItem>>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos/{id}")
    fun fetchPhotos(@Path("id") id: String): Call<PhotoDetails>


    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("search/photos")
    fun searchPhotos(@Query(value = "query") keyword: String): Call<UnsplashSearch>
}
