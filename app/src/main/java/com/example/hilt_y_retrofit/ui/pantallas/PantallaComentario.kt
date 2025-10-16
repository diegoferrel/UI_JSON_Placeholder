package com.example.hilt_y_retrofit.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hilt_y_retrofit.modelos.Comentario

@Composable
fun PantallaComentario(comentario: Comentario) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE3F2FD),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Column {

            Text(
                text = "${comentario.body}",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF0D47A1)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = comentario.body,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF1A237E)
            )
        }
    }
}
