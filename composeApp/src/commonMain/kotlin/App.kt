import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plusmobileapps.konnectivity.Konnectivity
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import myobservinginternetconnectionkmp.composeapp.generated.resources.Res
import myobservinginternetconnectionkmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val konnectivity = remember {
            Konnectivity()
        }
        val status by konnectivity.currentNetworkConnectionState.collectAsState()
        val isConnected by konnectivity.isConnectedState.collectAsState()

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = status.name,
                fontSize = MaterialTheme.typography.h3.fontSize,
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Text(
                text = isConnected.toString(),
                fontSize = MaterialTheme.typography.h2.fontSize,
            )
        }
    }
}