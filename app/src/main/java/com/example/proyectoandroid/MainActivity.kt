package com.example.proyectoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectoandroid.ui.theme.ProyectoAndroidTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComparisonScreen()
                }
            }
        }
    }
}

@Composable
fun ComparisonScreen(viewModel: ComparisonViewModel = viewModel()) {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Texto 1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Texto 2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(
            onClick = {
                viewModel.compareStrings(text1, text2)
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Comparar")
        }

        val result = viewModel.getResultLiveData()
        Text(
            text = result.value ?: "",
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun comparisonViewModel(): ComparisonViewModel {
    val viewModel: ComparisonViewModel = viewModel()
    return viewModel
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProyectoAndroidTheme {
        ComparisonScreen()
    }
}