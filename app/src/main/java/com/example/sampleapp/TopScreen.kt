import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleapp.HeaderSection
import com.example.sampleapp.SearchForm
import com.example.sampleapp.ui.theme.SampleAppTheme

@Composable
fun TopScreen(modifier: Modifier = Modifier) {
    Column {
        HeaderSection()
        SearchForm()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleAppTheme {
        TopScreen()
    }
}