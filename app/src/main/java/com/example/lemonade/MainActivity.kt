package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var make_lemonade_step by remember { mutableStateOf(4) }

    var step_instruction = when (make_lemonade_step) {
        1 -> R.string.Lemon_tree
        2 -> R.string.Lemon
        3 -> R.string.Glass_of_lemonade
        else -> R.string.Empty_glass
    }

    var step_contentDescription = when (make_lemonade_step) {
        1 -> R.string.Lemon_tree_description
        2 -> R.string.Lemon_description
        3 -> R.string.Glass_description
        else -> R.string.Empty_glass_description
    }

    val imageResource = when (make_lemonade_step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_fruit
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_empty_glass
    }


//    Spacer(modifier = Modifier.height(36.dp))

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = modifier.background(Color.Yellow)
                .height(48.dp)
                .fillMaxWidth(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically,

//            .fillMaxSize(),
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
//            color = Color.Yellow,
            )
        }

        Image(
            painter = painterResource(imageResource),
            contentDescription = step_contentDescription.toString(),
//            TODO alignment = CenterVertically,
        )
        Text(
            text = stringResource(id = step_instruction),
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Lemonade()
    }
}