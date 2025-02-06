package com.example.ddi8_tarea1_ape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ddi8_tarea1_ape.ui.theme.DDI8_Tarea1_APETheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DDI8_Tarea1_APETheme {
                MainScreen()
            }
        }
    }

}

@Preview
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)

        ) {
            TopSearchBar()
        }

        TextOverGrid()

        Row(
            modifier = Modifier
                .background(color = Color.DarkGray)
        ) {
            Destacados(destacados)
            Categorias(categorias)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSearchBar() {

    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = { Text("Buscar") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        trailingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.baseline_camera_alt_24),
                    contentDescription = "Camera"
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(Icons.Default.Search, contentDescription = "Search")

            }
        }
    ) {}


}

@Composable
fun TextOverGrid() {
    Row(
        Modifier
            .padding(8.dp)
    ) {
        Text(text = "Destacados", fontWeight = Bold)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Compra por categoría", fontWeight = Bold)
    }
}

@Composable
fun Destacados(list: List<String>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .width(80.dp)

    ) {

        items(list) { text ->
            Text(text
                , color = Color.White,
                modifier = Modifier.padding(14.dp)
            )

        }
    }

}

@Composable
fun Categorias(list: List<Categoria>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White),
        contentPadding = PaddingValues(8.dp),

        ) {
        items(list.size) { index ->
            Carta(categoria = list[index])
        }
    }
}

@Composable
fun Carta(categoria: Categoria) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = categoria.imageRes),
            contentDescription = categoria.title,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Text(
            text = categoria.title,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

data class Categoria(val title: String, val imageRes: Int)

val categorias = listOf(
    Categoria("Maquillaje", R.drawable.image1),
    Categoria("Blusas y camisas", R.drawable.image2),
    Categoria("Pantalones", R.drawable.image3),
    Categoria("Vestidos de mujer", R.drawable.image4),
    Categoria("Cuidado del cabello", R.drawable.image5),
    Categoria("Cuidado personal", R.drawable.image6),
    Categoria("Tops de hombre", R.drawable.image7),
    Categoria("Conjuntos de hombres", R.drawable.image8),
    Categoria("Juguetes electrónicos", R.drawable.image9)
)

val destacados = listOf(
    "Hogar y cocina",
    "Ropa de mujer",
    "Tallas Plus Para Mujer",
    "Zapatos de mujer",
    "Lencería y pijamas de mujer",
    "Ropa de hombre",
    "Calzado de hombre"
)





