package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.Lab2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                LemonApp()
                LemonadeText()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1)} //declarar variable donde se guarde y recuerde la acción del usuario
    var clickCuantity = (2..4).random()
    var currentClicks by remember { mutableStateOf(0)}

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background // color para backgrounds
    ) {
        when(currentStep){ //observer
            1 -> { // imagen del árbol de limones
                Box (
                    contentAlignment = Alignment.Center, // Centra la imagen dentro de la Box
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.background1),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .width(260.dp) // Ancho deseado
                            .height(260.dp), // Altura deseada
                        contentScale = ContentScale.Crop
                    )
                    Text(text = stringResource(R.string.lemon_select),
                        textAlign = TextAlign.Center,
                        lineHeight = 2.em,
                        fontSize = 27.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xff20c4f0),
                        modifier = Modifier.offset(x=0.dp, y = 170.dp)) //usa string declarada en xml
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_tree), //usa imagen importada
                        contentDescription = stringResource(R.string.lemon_tree_content_description), //usa string de descripción declarada en xml
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .wrapContentSize()
                            .clickable { //hace que pase al step 2
                                currentStep = 2
                            }
                    )
                }
            }

            2 -> { // imagen del limón
                Box (
                    contentAlignment = Alignment.Center, // Centra la imagen dentro de la Box
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.background1),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .width(260.dp) // Ancho deseado
                            .height(260.dp), // Altura deseada
                        contentScale = ContentScale.Crop
                    )
                    Text(text = stringResource(R.string.lemon_squeeze),
                        textAlign = TextAlign.Center,
                        lineHeight = 2.em,
                        fontSize = 27.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xff20c4f0),
                        modifier = Modifier.offset(x=0.dp, y = 170.dp)) //usa string declarada en xml
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze), //usa imagen importada
                        contentDescription = stringResource(R.string.lemon_content_description), //usa string de descripción declarada en xml
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .wrapContentSize()
                            .clickable { //hace que pase al step 3
                                println(clickCuantity)
                                currentClicks++
                                if (clickCuantity == currentClicks) {
                                    currentStep = 3
                                }
                            }
                    )
                }
            }

            3 -> { // imagen del vaso de limonada
                Box (
                    contentAlignment = Alignment.Center, // Centra la imagen dentro de la Box
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.background1),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .width(260.dp) // Ancho deseado
                            .height(260.dp), // Altura deseada
                        contentScale = ContentScale.Crop
                    )
                    Text(text = stringResource(R.string.lemonade_drink),
                        textAlign = TextAlign.Center,
                        lineHeight = 2.em,
                        fontSize = 27.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xff20c4f0),
                        modifier = Modifier.offset(x=0.dp, y = 170.dp)) //usa string declarada en xml
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_drink), //usa imagen importada
                        contentDescription = stringResource(R.string.glass_content_description), //usa string de descripción declarada en xml
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .wrapContentSize()
                            .clickable { //hace que pase al step 4
                                currentStep = 4
                            }
                    )
                }
            }

            4 -> { // imagen del vaso vacío
                Box (
                    contentAlignment = Alignment.Center, // Centra la imagen dentro de la Box
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.background1),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .width(260.dp) // Ancho deseado
                            .height(260.dp), // Altura deseada
                        contentScale = ContentScale.Crop
                    )
                    Text(text = stringResource(R.string.glass_restart),
                        textAlign = TextAlign.Center,
                        lineHeight = 2.em,
                        fontSize = 27.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xff20c4f0),
                        modifier = Modifier.offset(x=0.dp, y = 170.dp)) //usa string declarada en xml
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_restart), //usa imagen importada
                        contentDescription = stringResource(R.string.empty_glass_content_description), //usa string de descripción declarada en xml
                        modifier = Modifier
                            .offset(x=0.dp, y = -80.dp)
                            .wrapContentSize()
                            .clickable { //hace que pase al step 1
                                currentStep = 1
                                currentClicks = 0
                                clickCuantity = (2..4).random()
                            }
                    )
                }
            }

        }
    }
}

@Composable
fun LemonadeText() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Lemonade",
            modifier = Modifier.offset(x=0.dp, y = 50.dp),
            textAlign = TextAlign.Center,
            color = Color(0xffffc614),
            fontWeight = FontWeight.Black,
            lineHeight = 4.em,
            fontSize = 38.sp,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 3.sp)
    }
}

@Preview()
@Composable
fun DefaultPreview() {
    Lab2Theme {
        LemonApp()
        LemonadeText()
    }
}