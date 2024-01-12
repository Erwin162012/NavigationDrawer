package com.example.navigationdrawer

import android.os.Bundle
import androidx.compose.ui.res.painterResource
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.ui.graphics.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Navigation(){

    // Definimos una implementación personalizada de la interfaz NavigationDrawerItemColors
    val customColors = object : NavigationDrawerItemColors {
        @Composable
        override fun iconColor(selected: Boolean): State<Color> {
            return rememberUpdatedState(Color.White)
        }
        @Composable
        override fun textColor(selected: Boolean): State<Color> {
            return rememberUpdatedState(Color(220, 189, 83))
        }
        @Composable
        override fun badgeColor(selected: Boolean): State<Color> {
            return rememberUpdatedState(Color.Red)
        }
        @Composable
        override fun containerColor(selected: Boolean): State<Color> {
            return rememberUpdatedState(Color(0, 13, 29))
        }
    }

    var elementoActual by remember { mutableStateOf(0) } /* guarda el índice de la pantalla actualmente seleccionada en el menú.
     Se utiliza para determinar qué pantalla debe mostrarse en el contenido principal.*/

    val estadoMenu = rememberDrawerState(DrawerValue.Closed)/*gestiona el estado del menú lateral. Contiene información sobre si el menú está abierto o cerrado*/

    val accionMovimiento = rememberCoroutineScope()/*Se utiliza para controlar y realizar acciones asíncronas, como abrir y cerrar el menú lateral*/

    val controladorNavegacion = rememberNavController()/*Se utiliza para realizar la navegación entre diferentes pantallas de la aplicación.
    Permite la transición entre las distintas secciones de la app en respuesta a eventos, como selecciones de menú*/

    ModalNavigationDrawer(
        drawerState = estadoMenu,
        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = Color(0, 13, 29)
            ) {
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    label = { Text("Hogar",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 5.sp,
                        fontSize = 30.sp) },
                    selected = (elementoActual == 0),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 0
                    },
                    colors = customColors
                )

                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Default.Call, contentDescription = null) },
                    label = { Text(text = "Electronica",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 5.sp,
                        fontSize = 30.sp) },
                    selected = (elementoActual == 1),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 1
                    },
                    colors = customColors
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
                    label = { Text(text = "Ropa",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 5.sp,
                        fontSize = 30.sp) },
                    selected = (elementoActual == 2),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 2
                    },
                    colors = customColors
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Default.Notifications, contentDescription = null) },
                    label = { Text(text = "Cocina",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 5.sp,
                        fontSize = 30.sp) },
                    selected = (elementoActual == 3),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 3
                    },
                    colors = customColors
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Default.Face, contentDescription = null) },
                    label = { Text(text = "Juguetes",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 5.sp,
                        fontSize = 30.sp) },
                    selected = (elementoActual == 4),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 4
                    },
                    colors = customColors
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
                    label = { Text(text = "Decoracion",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 5.sp,
                        fontSize = 30.sp) },
                    selected = (elementoActual == 5),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 5
                    },
                    colors = customColors
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Power Shopping",
                            color = Color(220, 189, 83),
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            accionMovimiento.launch { estadoMenu.open() }
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.logo1),
                                contentDescription = "Menu",
                            )
                        }
                    },
                    colors = TopAppBarDefaults.largeTopAppBarColors
                        (containerColor = Color(0, 13, 29))
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /* Llama a ScreenContent con el elementoActual y el controladorNavegacion
                para renderizar el contenido correspondiente en función de la opción seleccionada*/
                ScreenContent(elementoActual, controladorNavegacion)
            }
        }
    }
}
@Composable
fun ScreenContent(elementoActual: Int, navController: NavHostController) {
    when (elementoActual) {
        0 -> {
            val hogar = Hogar()
            hogar.renderScreenContent(navController)
        }
        1 -> {
            val electronica = Electronica()
            electronica.renderScreenContent(navController)
        }
        2 -> {
            val ropa = Ropa()
            ropa.renderScreenContent(navController)
        }
        3 -> {
            val cocina = Cocina()
            cocina.renderScreenContent(navController)
        }
        4 -> {
            val juguetes = Juguetes()
            juguetes.renderScreenContent(navController)
        }
        5 -> {
            val decoracion = Decoracion()
            decoracion.renderScreenContent(navController)
        }
        else -> {
            Text("Pantalla no encontrada")
        }
    }
}
@Composable
fun ScreenContent(title: String, navController: NavHostController) {
    when (title) {
        "Hogar" -> {
            val hogar = Hogar()
            hogar.renderScreenContent(navController)
        }
        "Electrónica" -> {
            val electronica = Electronica()
            electronica.renderScreenContent(navController)
        }
        "Ropa" -> {
            val ropa = Ropa()
            ropa.renderScreenContent(navController)
        }
        "Cocina" -> {
            val cocina = Cocina()
            cocina.renderScreenContent(navController)
        }
        "Juguetes" -> {
            val juguetes = Juguetes()
            juguetes.renderScreenContent(navController)
        }
        "Decoración" -> {
            val decoracion = Decoracion()
            decoracion.renderScreenContent(navController)
        }
        else -> {
            Text("Pantalla no encontrada")
        }
    }
}