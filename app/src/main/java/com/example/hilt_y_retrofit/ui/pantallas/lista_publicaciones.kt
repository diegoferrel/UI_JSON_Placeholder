package com.example.hilt_y_retrofit.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.hilt_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun ListaPublicaciones(
        modificador: Modifier = Modifier,
        controlodar_publicaciones: ControladorPublicaciones = hiltViewModel(),
        navegar_a_publiacion: () -> Unit = {}
) {
    Log.v("PantallaPublicacion", "Valor del controlador: $controlodar_publicaciones")

    controlodar_publicaciones.obtener_publicaciones()

    if (controlodar_publicaciones.publicaciones.value.isNotEmpty()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (publicacion in controlodar_publicaciones.publicaciones.value) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFE3F2FD), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                        .padding(12.dp)
                        .clickable {
                            controlodar_publicaciones.seleccionar_publicacion(id = publicacion.id)
                            navegar_a_publiacion()
                        },
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Publicación: ${publicacion.title}",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF0D47A1)
                    )
                    Text(
                        text = publicacion.body,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF1A237E)
                    )
                }
            }
        }
    } else {
        Text(
            text = "Disculpa las molestias, pero estamos obteniendo las últimas publicaciones. Favor de esperar...",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    ListaPublicaciones()
}