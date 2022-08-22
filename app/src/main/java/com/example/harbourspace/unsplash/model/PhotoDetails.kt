package com.example.harbourspace.unsplash.model


data class PhotoDetails(
    val blur_hash: String?,
    val color: String?,
    val created_at: String?,
    val current_user_collections: List<CurrentUserCollection>?,
    val description: String?,
    val downloads: Int?,
    val exif: Exif?,
    val height: Int?,
    val id: String?,
    val liked_by_user: Boolean?,
    val likes: Int?,
    val location: Location?,
    val public_domain: Boolean?,
    val updated_at: String?,
    val user: User?,
    val width: Int?,
    val views: Int?
)