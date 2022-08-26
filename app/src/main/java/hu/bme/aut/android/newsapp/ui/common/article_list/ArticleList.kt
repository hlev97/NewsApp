package hu.bme.aut.android.newsapp.ui.common.article_list

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hu.bme.aut.android.newsapp.ui.common.article_item.ArticleItem
import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel
import hu.bme.aut.android.newsapp.ui.theme.ARTICLE_ITEM_PADDING

@Composable
fun ArticleList(
    articleItems: List<ArticleItemModel>,
    onArticleItemClick: (Int) -> Unit
) {
    LazyColumn {
        articleItems.forEachIndexed { index, articleItem ->
            item {
                if (index == 0) {
                    Divider(
                        modifier = Modifier.height(ARTICLE_ITEM_PADDING),
                        color = Color.Transparent
                    )
                }
                ArticleItem(
                    articleItem = articleItem,
                    onClick = {
                        onArticleItemClick(articleItem.id)
                    }
                )
                Divider(
                    modifier = Modifier.height(ARTICLE_ITEM_PADDING),
                    color = Color.Transparent
                )
            }
        }
    }
}
