package com.example.harbourspace


import android.net.Uri
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class UnsplashHelper {


    companion object {
        private const val BASE_URL = "https://api.unsplash.com"
        private const val ACCESS_KEY = "zi-TYuGc4juUoaEBZ46kkfZ-dHQGKvicqDwyQji_hRI"

        const val SIZE_SMALL = "fm=webp&w=400&fit=max"
        const val SIZE_FULL = "fm=webp&w=1600&fit=max"
    }

    fun getImageUrl(url: String, size: String): String {
        return "$url&$size"
    }

    fun getPhotoUrl(id: String): String {
        val path = "/photos/$id"
        val uri = Uri.parse(BASE_URL)
            .buildUpon()
            .appendEncodedPath(path)
            .build()

        val client = OkHttpClient ()
        val request = Request.Builder()
            .url(uri.toString())
            .addHeader("Accept-Version", "v1")
            .addHeader("Authorization", "Client-ID $ACCESS_KEY")
            .get()
            .build()

        val response = client.newCall(request).execute()
        val jsonDataString = response.body?.string()

        val json = JSONObject(jsonDataString)
        if (!response.isSuccessful) {
            val errors = json.getJSONArray("errors").join(", ")
            throw Exception(errors)
        }

        val rawUrl = json.getJSONObject("urls").getString("raw")
        return rawUrl
    }

}

