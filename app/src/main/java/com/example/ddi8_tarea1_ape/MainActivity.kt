package com.example.ddi8_tarea1_ape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ddi8_tarea1_ape.ui.theme.DDI8_Tarea1_APETheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DDI8_Tarea1_APETheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        SmallTopAppBarExample()
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Column(modifier = Modifier.weight(0.3f)) {
                DestacadosSection(items = destacados)
            }
            Column(modifier = Modifier.weight(0.7f)) {
                CompraPorCategoriaSection(categories = compraPorCategoria)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,),
        title = {
            Text("Small Top App Bar")
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Menu"
                )
            }
        }
    )
}



@Composable
fun DestacadosSection(items: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Title
        Text(
            text = "Destacados",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Vertical List of Text Items
        items.forEach { item ->
            Text(
                text = item,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
fun CompraPorCategoriaSection(categories: List<Category>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Title
        Text(
            text = "Compra por categoría",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Grid of Categories
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(categories.size) { index ->
                CategoryCard(category = categories[index])
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        // Category Image
        Image(
            painter = painterResource(id = category.imageRes),
            contentDescription = category.title,
            modifier = Modifier.size(80.dp)
        )
        // Category Text
        Text(
            text = category.title,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

// Data Model
data class Category(val title: String, val imageRes: Int)

// Sample Data
val destacados = listOf(
    "Hogar y cocina",
    "Ropa de mujer",
    "Tallas Plus Para Mujer",
    "Zapatos de mujer",
    "Lencería y pijamas de mujer",
    "Ropa de hombre",
    "Calzado de hombre"
)

val compraPorCategoria = listOf(
    Category("Maquillaje", R.drawable.image1),
    Category("Blusas y camisas", R.drawable.image2),
    Category("Pantalones", R.drawable.image3),
    Category("Vestidos de mujer", R.drawable.image4),
    Category("Cuidado del cabello", R.drawable.image5),
    Category("Cuidado personal", R.drawable.image6),
    Category("Tops de hombre", R.drawable.image7),
    Category("Conjuntos de hombres", R.drawable.image8),
    Category("Juguetes electrónicos", R.drawable.image9)
)



