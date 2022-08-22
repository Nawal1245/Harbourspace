package com.example.harbourspace.unsplash.data.cb

import com.example.harbourspace.unsplash.model.UnsplashItem

interface UnsplashResult {

    fun onDataFetchedSuccess(images: List<UnsplashItem>)

    fun onDataFetchedFailed()
}