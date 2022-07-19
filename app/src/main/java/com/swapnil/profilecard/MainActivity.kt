package com.swapnil.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapnil.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardTheme {
        MainScreen()
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top),
        shape = AbsoluteCutCornerShape(topRight = 16.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Composable
fun ProfileContent() {
    Text(text = "Swapnil Bhojwani", modifier = Modifier.padding(8.dp))
}

@Composable
fun ProfilePicture() {
    Card(shape = CircleShape, border = BorderStroke(1.dp,Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.swapnil_profile),
            contentDescription = "content",
            Modifier.size(72.dp)
        )
    }
}

@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
        ProfileCard()
    }
}
