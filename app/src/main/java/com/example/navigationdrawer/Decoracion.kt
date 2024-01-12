package com.example.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


class Decoracion() {
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
                                    painter = painterResource(id = R.drawable.d1),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(3.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.d2),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(3.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.d3),
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
                                "Globos Personalizados",
                                "Globos Personalizados tu solo pide y lo tienes",
                                R.drawable.decoracion1,
                                totalCantidad,
                                20,
                                totalPrecio
                            )
                        }
                        item {
                            crearElementoProdcuto(
                                "Globos Básicos",
                                "Básicos de con mucha utilidad para cualquier festividad o manualidad",
                                R.drawable.decoracion2,
                                totalCantidad,
                                7,
                                totalPrecio
                            )
                        }
                        item {
                            crearElementoProdcuto(
                                "Velas Navideñas",
                                "Velas de larga duracion con aroma suave y de muy buena cera",
                                R.drawable.decoracion3,
                                totalCantidad,
                                14,
                                totalPrecio
                            )
                        }
                        item {
                            crearElementoProdcuto(
                                "Calabazas de Halloween",
                                "Calabazas de plastico con luces led y larga duracion",
                                R.drawable.decoracion4,
                                totalCantidad,
                                29,
                                totalPrecio
                            )
                        }
                        item {
                            crearElementoProdcuto(
                                "Mascaras de carnaval",
                                "Carnaval es mejor con buenas mascaras y creatividad",
                                R.drawable.decoracion5,
                                totalCantidad,
                                12,
                                totalPrecio
                            )
                        }
                        item {
                            Text(
                                text = "Lo Mejor para Tus Días Festivos \n",
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