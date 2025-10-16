package com.example.hilt_y_retrofit.ui.pantallas


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hilt_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
            modificador: Modifier = Modifier,
            controlador_publicaciones: ControladorPublicaciones = hiltViewModel(),
    ) {
    val publicacion = controlador_publicaciones.publicacion_seleccionada.value
    val comentarios by controlador_publicaciones.comentarios
    val comentarioSeleccionado = controlador_publicaciones.comentarioSeleccionado.value

    if (comentarioSeleccionado != null) {
        PantallaComentarioADetalle(
            comentario = comentarioSeleccionado,
            cerrar = { controlador_publicaciones.cerrarComentario() }
        )
        return
    }
    Column(
        modifier = modificador
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFBBDEFB),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                )
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = publicacion.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF0D47A1)
                )
                Text(
                    text = publicacion.body,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF1A237E)
                )
            }
        }

        Text(
            text = "Comentarios",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF1976D2)
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            comentarios.forEach { comentario ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            controlador_publicaciones.seleccionarComentario(comentario)
                        }
                ) {
                    PantallaComentario(comentario)
                }
            }


        }
    }
}