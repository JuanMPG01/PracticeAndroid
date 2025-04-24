package com.example.electrodomesticact
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.electrodomesticact.ui.theme.ElectrodomesticActTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ElectrodomesticActTheme {
                LavadoraUI()
            }
        }
    }
}

@Composable
fun LavadoraUI() {
    val lavadora = remember { Lavadora("LG", "TwinWash", 15, true) }

    val programas = listOf("rápido", "intenso", "eco")
    var mensaje by remember { mutableStateOf("") }
    var programaSeleccionado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Lavadora: ${lavadora.marca} ${lavadora.modelo}")
        Text("Estado: ${lavadora.estado()}")

        Text("Selecciona un program:")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            programas.forEach { programa ->
                Button(onClick = {
                    lavadora.seleccionarPrograma(programa)
                    programaSeleccionado = programa
                    mensaje = "Programa '$programa' seleccionado."
                }) {

                }
            }
        }

        Button(onClick = {
            mensaje = lavadora.iniciarLavado()
        }) {
            Text("Iniciar Lavado")
        }

        Button(onClick = {
            mensaje = lavadora.detenerLavado()
        }) {
            Text("Detener Lavado")
        }

        if (mensaje.isNotEmpty()) {
            Text("→ $mensaje")
        }
    }
}
