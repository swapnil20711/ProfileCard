package com.swapnil.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.swapnil.profilecard.ui.theme.LightGreen
import com.swapnil.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardTheme {
                UsersApplication()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardTheme {
        UsersApplication()
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfileScreen(0)
}

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top)
            .clickable {
                clickAction.invoke()
            },
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.isActive, userProfile.imageUrl, 108.dp)
            ProfileContent(userProfile.userName, userProfile.isActive, Alignment.Start)
        }
    }
}

@Composable
fun ProfileContent(userName: String, active: Boolean, alignment: Alignment.Horizontal) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = alignment
    ) {
        Text(text = userName, style = MaterialTheme.typography.h5, color = Color.Black)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (active)
                    "Active now!"
                else
                    "Offline",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ProfilePicture(isActive: Boolean, imageUrl: String, dp: Dp) {
    Card(
        Modifier
            .size(dp)
            .padding(16.dp),
        shape = CircleShape, border = BorderStroke(
            2.dp,
            if (isActive)
                LightGreen
            else
                Color.Red
        )
    ) {
        CustomImage(imageUrl = imageUrl)
    }
}

@Composable
fun CustomImage(imageUrl: String) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .transformations(CircleCropTransformation()).build(),
        loading = { CircularProgressIndicator() },
        contentDescription = null
    )
}

@Composable
fun UsersListScreen(userProfiles: List<UserProfile>, navController: NavHostController) {
    Scaffold(topBar = { AppBar() }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn() {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile) {
                        navController.navigate("user_detail/${userProfile.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(backgroundColor = Color.Blue, navigationIcon = {
        IconButton(onClick = {
        }) {
            Icon(Icons.Default.Home, "Home")
        }
    }, title = { Text(text = "Messaging application") })
}


/*
* User profile code here*/
@Composable
fun UserProfileScreen(userId: Int) {
    val userProfile = userProfileList.first { userProfile ->
        userId == userProfile.id
    }
    Scaffold(topBar = { AppBar() }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ProfilePicture(
                    isActive = userProfile.isActive,
                    imageUrl = userProfile.imageUrl,
                    156.dp
                )
                ProfileContent(
                    userName = userProfile.userName,
                    active = userProfile.isActive,
                    Alignment.CenterHorizontally
                )
            }
        }
    }
}

/*Composable to implement navigation in jetpack
* */
@Composable
fun UsersApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UsersListScreen(userProfileList, navController)
        }
        composable("user_detail/{userId}", arguments = listOf(navArgument("userId") {
            type = NavType.IntType
        })) { navBackStackEntry ->
            UserProfileScreen(navBackStackEntry.arguments!!.getInt("userId"))
        }
    }
}
