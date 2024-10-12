package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridExample()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        Greeting("Android")
    }
}

@Composable
fun LazyColumnExample() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre los ítems
    ) {
        items(10) { index ->
            Text(
                text = "Item #$index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp) // Espaciado interno de cada item
                    .background(Color.LightGray) // Color de fondo
                    .clip(RoundedCornerShape(8.dp)), // Bordes redondeados
                color = Color.Black, // Color del texto
                fontSize = 18.sp, // Tamaño de fuente
                fontWeight = FontWeight.Bold // Negrita
            )
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow {
        items(20) { index ->
            Text("Item #$index")
        }
    }
}

@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Padding externo para toda la cuadrícula
        contentPadding = PaddingValues(8.dp), // Padding interno
        verticalArrangement = Arrangement.spacedBy(8.dp), // Espacio entre filas
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre columnas
    ) {
        items(9) { index ->
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .aspectRatio(1f) // Mantiene los items cuadrados
                    .clip(RoundedCornerShape(8.dp)) // Bordes redondeados
                    .padding(8.dp), // Padding dentro de cada ítem
                contentAlignment = Alignment.Center // Centrar el contenido en cada ítem
            ) {
                Text(
                    text = "Item #$index",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
