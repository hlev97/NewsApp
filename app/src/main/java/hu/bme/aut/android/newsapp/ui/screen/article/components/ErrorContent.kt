package hu.bme.aut.android.newsapp.ui.screen.article.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import hu.bme.aut.android.newsapp.ui.theme.SMALL_PADDING

@Composable
fun ErrorContent(
    errorMessage: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.errorContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Error,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = SMALL_PADDING)
                .fillMaxSize(0.35f),
            tint = MaterialTheme.colorScheme.onErrorContainer
        )

        Text(
            text = errorMessage,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@Preview
@Composable
fun ErrorContentPreview() {
    ErrorContent(errorMessage = "error")
}
