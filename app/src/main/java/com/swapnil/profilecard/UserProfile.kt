package com.swapnil.profilecard

data class UserProfile constructor(
    val userName: String,
    val isActive: Boolean,
    val imageUrl: String
)

val userProfileList = arrayListOf(
    UserProfile(
        userName = "Swapnil Bhojwani",
        isActive = true,
        "https://picsum.photos/id/1002/4312/2868"
    ),
    UserProfile(
        userName = "Anna Joans",
        isActive = false,
        "https://picsum.photos/id/1011/367/267"
    ),
    UserProfile(
        userName = "Swapnil Bhojwani",
        isActive = true,
        "https://picsum.photos/id/1015/6000/4000"
    ),
    UserProfile(
        userName = "Anna Joans",
        isActive = false,
        "https://picsum.photos/id/1036/4608/3072"
    ),
    UserProfile(
        userName = "Swapnil Bhojwani",
        isActive = true,
        "https://picsum.photos/id/104/3840/2160"
    ),
    UserProfile(
        userName = "Anna Joans",
        isActive = false,
        "https://picsum.photos/id/1050/6000/4000"
    )
)