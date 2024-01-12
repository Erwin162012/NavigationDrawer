package com.example.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

class Hogar() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun renderScreenContent(navController: NavHostController) {
            var totalCantidad = remember { mutableStateOf(0) }
            var totalPrecio = remember { mutableStateOf(0.0) }
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.height(45.dp),
                        title = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.h1),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(3.dp)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.h2),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(3.dp)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.h3),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(3.dp)
                                    )
                                    }
                            }
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Color(220, 189, 83),
                            titleContentColor = Color(0, 13, 29),
                        ),
                    )
                },
                content = { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color(220, 189, 83)),
                    ) {
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.fondotienda),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clipToBounds()
                            )
                        }
                    }
                    LazyColumn(
                        content = {
                            //items de mi scrollpanel
                            item {
                                crearElementoProdcuto(
                                    "Cama de Adrian",
                                    "Cama personalizada de princesas muy comoda y de alto nivel con motivos infantiles hecha de madera y plastico",
                                    R.drawable.hogar1,
                                    totalCantidad,
                                    900,
                                    totalPrecio
                                )
                            }
                            item {
                                crearElementoProdcuto(
                                    "Sofá Moderno",
                                    "Sofá hecho de un material muy esclusivo con un color vino llamativo, ademas de ser muy comodo",
                                    R.drawable.hogar2,
                                    totalCantidad,
                                    500,
                                    totalPrecio
                                )
                            }
                            item {
                                crearElementoProdcuto(
                                    "Cama Grande",
                                    "Cama para parejas con amplio espacio y comodidad, ortopedica y facil de limpiar",
                                    R.drawable.hogar3,
                                    totalCantidad,
                                    2000,
                                    totalPrecio
                                )
                            }
                            item {
                                crearElementoProdcuto(
                                    "Lampara Básica",
                                    "Lamparas de mucha variedad con distintos diseños y colores",
                                    R.drawable.hogar4,
                                    totalCantidad,
                                    24,
                                    totalPrecio
                                )
                            }
                            item {
                                crearElementoProdcuto(
                                    "Mesa de Madera",
                                    "Mesa basica de madera muy economica para cualquier necesidad",
                                    R.drawable.hogar5,
                                    totalCantidad,
                                    80,
                                    totalPrecio
                                )
                            }
                            item {
                                Text(
                                    text = "Tu Hogar con la Mejor Comodidad \n",
                                    style = TextStyle(
                                        fontFamily = FontFamily.Monospace,
                                        letterSpacing = 4.sp,
                                        background = Color(0, 13, 29),
                                        color = Color(220, 189, 83),
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding( 45.dp)
                                        .wrapContentWidth(Alignment.CenterHorizontally),
                                    fontSize = 20.sp
                                )
                            }
                        }, modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 60.dp)
                    )
                },
                bottomBar = { TopAppBar(
                    modifier = Modifier.height(45.dp),
                    title = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.global),
                                contentDescription = "Imagen",
                                modifier = Modifier.padding(end = 15.dp)
                            )
                            Text(
                                modifier = Modifier
                                    .padding(0.dp)
                                    .wrapContentWidth(Alignment.Start),
                                text = "Visitanos en PowerShopping.com",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                color = Color.Black,
                            )
                            Image(
                                painter = painterResource(id = R.drawable.global),
                                contentDescription = "Imagen",
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(220, 189, 83),
                        titleContentColor = Color(0, 13, 29),
                    ),
                )}
            )
        }
    }

