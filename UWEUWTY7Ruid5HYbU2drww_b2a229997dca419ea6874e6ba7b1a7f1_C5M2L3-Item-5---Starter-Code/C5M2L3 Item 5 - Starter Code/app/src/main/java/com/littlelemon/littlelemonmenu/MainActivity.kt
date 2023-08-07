import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val materialBlue700 = Color(0xFF1976D2)
			val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
			Scaffold(
				scaffoldState = scaffoldState,
				topBar = {
					TopAppBar(
//						title = { Text(resources.getString(R.string.app_name)) }
						title = { Text(text = "Little Lemon")},
						contentColor = Color.White,
						backgroundColor = materialBlue700
					)
				},
				content = { paddingValues ->
					MenuContent(paddingValues = paddingValues)
				}
			)
		}
	}
}

@Composable
fun MenuContent(paddingValues: PaddingValues) {
	val configuration = LocalConfiguration.current
	val orientation = configuration.orientation

	Surface(modifier = Modifier.padding(paddingValues)) {
		val menuPadding = 8.dp
		when (orientation) {
			ORIENTATION_LANDSCAPE -> {
				Column {
					Row(Modifier.fillMaxWidth()) {
						Text(
							"Appetizers",
							modifier = Modifier
								.weight(0.5f)
								.background(Color.Blue)
								.padding(menuPadding)
								.fillMaxWidth()
						)
						Text(
							"Salads",
							modifier = Modifier
								.weight(0.5f)
								.padding(menuPadding)
								.fillMaxWidth()
						)
					}
					Row(Modifier.fillMaxWidth()) {
						Text(
							"Drinks",
							modifier = Modifier
								.weight(0.5f)
								.background(Color.Red)
								.padding(menuPadding)
								.fillMaxWidth()
						)
						Text(
							"Mains",
							modifier = Modifier
								.weight(0.5f)
								.background(Color.Green)
								.padding(menuPadding)
								.fillMaxWidth()
						)
					}
				}
			}
			else -> {
				Column {
					Text(
						"Appetizers",
						modifier = Modifier
							.weight(0.25f)
							.background(Color.Blue)
							.padding(menuPadding)
							.fillMaxWidth()
					)
					Text(
						"Salads",
						modifier = Modifier
							.weight(0.25f)
							.padding(menuPadding)
							.fillMaxWidth()
					)
					Text(
						"Drinks",
						modifier = Modifier
							.weight(0.25f)
							.background(Color.Red)
							.padding(menuPadding)
							.fillMaxWidth()
					)
					Text(
						"Mains",
						modifier = Modifier
							.weight(0.25f)
							.background(Color.Green)
							.padding(menuPadding)
							.fillMaxWidth()
					)
				}
			}
		}
	}
}

@Preview
@Composable
fun MenuContentPreview() {
	MenuContent(paddingValues = PaddingValues(16.dp))
}
