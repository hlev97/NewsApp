package hu.bme.aut.android.newsapp.ui.screen.article.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ArticleContent(
    modifier: Modifier,
    articleText: String
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = articleText,
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Justify
        )
    }
}
