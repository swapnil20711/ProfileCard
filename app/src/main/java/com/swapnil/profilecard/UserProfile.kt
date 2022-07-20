package com.swapnil.profilecard

data class UserProfile constructor(
    val userName: String,
    val isActive: Boolean,
    val drawableId: Int
)

val userProfileList = arrayListOf(
    UserProfile(userName = "Swapnil Bhojwani", isActive = true, R.drawable.swapnil_profile),
    UserProfile(userName = "Anna Joans", isActive = false, R.drawable.profile_picture2),
    UserProfile(userName = "Swapnil Bhojwani", isActive = true, R.drawable.swapnil_profile),
    UserProfile(userName = "Anna Joans", isActive = false, R.drawable.profile_picture2),
    UserProfile(userName = "Swapnil Bhojwani", isActive = true, R.drawable.swapnil_profile),
    UserProfile(userName = "Anna Joans", isActive = false, R.drawable.profile_picture2)
)