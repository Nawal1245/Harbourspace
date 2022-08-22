package com.example.harbourspace.unsplash.data

import android.content.ContentValues.TAG
import android.util.Log
import com.example.harbourspace.unsplash.UnsplashViewModel
import com.example.harbourspace.unsplash.data.cb.UnsplashResult
import com.example.harbourspace.unsplash.model.UnsplashItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val TAG = "UnsplashApiProvider"
private const val BASE_URL = "https://api.unsplash.com/"



class UnsplashApiProvider {

    private val retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create<UnsplashAPIClient>()
    }

    fun fetchImages(cb: UnsplashResult) {
        retrofit.fetchPhotos().enqueue(object : Callback<List<UnsplashItem>> {
            override fun onResponse(call: Call<List<UnsplashItem>>, response: Response<List<UnsplashItem>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d(TAG, "Response: ${response.body()}")
                    cb.onDataFetchedSuccess(response.body()!!)
                } else {
                    cb.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
                Log.e(TAG, "Error loading images", t)
                cb.onDataFetchedFailed()
            }
        })
    }
}