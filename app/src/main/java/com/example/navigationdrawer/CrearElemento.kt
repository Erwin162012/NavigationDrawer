package com.example.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//metodo para crear items por filas con parametros especificos
        @Composable
        fun crearElementoProdcuto(
            titulo: String,
            desc: String,
            imagenResId: Int,
            total: MutableState<Int>,
            price: Int,
            totalPrecio: MutableState<Double>
        ) {
            var cantidad by remember { mutableStateOf(0) }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = imagenResId),
                    contentDescription = "Imagen",
                    modifier = Modifier.padding(start = 90.dp)
                )
                Text(
                    text = "$titulo  $price €",
                    fontWeight = FontWeight.Bold,
                    color = Color(220, 189, 83),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .background(color = Color(0, 13, 29)),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Text(
                    text = "$desc\n",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(220, 189, 83),
                    modifier = Modifier
                        .padding(horizontal = 80.dp)
                        .background(
                            color = Color(0, 13, 29),
                            shape = RoundedCornerShape(8.dp) // Ajusta el radio según sea necesario
                        ),
                    textAlign = TextAlign.Center
                )
            }
        }

