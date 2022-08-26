package hu.bme.aut.android.newsapp.ui.common.article_item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import hu.bme.aut.android.newsapp.R
import hu.bme.aut.android.newsapp.ui.common.model.ArticleItemModel
import hu.bme.aut.android.newsapp.ui.theme.*
import hu.bme.aut.android.newsapp.util.FormatUtil.formatDate

@Composable
fun ArticleItem(
    articleItem: ArticleItemModel,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .clickable { onClick() },
        shape = RoundedCornerShape(ARTICLE_ITEM_CORNER_RADIUS),
        shadowElevation = 2.dp
    ) {
        ConstraintLayout {
            val (image, title, author, publishedAt) = createRefs()

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(articleItem.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start, ARTICLE_ITEM_PARENT_PADDING)
                        top.linkTo(parent.top, ARTICLE_ITEM_PARENT_PADDING)
                        end.linkTo(title.start)
                        bottom.linkTo(parent.bottom, ARTICLE_ITEM_PARENT_PADDING)
                    }
                    .size(ARTICLE_ITEM_IMAGE_SIZE)
                    .clip(RoundedCornerShape(ARTICLE_ITEM_IMAGE_CORNER_RADIUS))
            )

            Text(
                text = articleItem.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(image.end, ARTICLE_ITEM_IMAGE_PADDING)
                        top.linkTo(parent.top, ARTICLE_ITEM_PARENT_PADDING)
                        end.linkTo(parent.end, ARTICLE_ITEM_PARENT_PADDING)
                        bottom.linkTo(author.top)
                    }
                    .fillMaxWidth(0.7f),
                fontSize = 20.sp
            )

            Text(
                text = articleItem.author,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier
                    .constrainAs(author) {
                        start.linkTo(image.end, ARTICLE_ITEM_IMAGE_PADDING)
                        top.linkTo(title.bottom)
                        bottom.linkTo(parent.bottom, ARTICLE_ITEM_PARENT_PADDING)
                    }
                    .fillMaxWidth(0.3f)
            )

            Text(
                text = articleItem.publishedAt.formatDate(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(publishedAt) {
                    top.linkTo(title.bottom)
                    end.linkTo(parent.end, ARTICLE_ITEM_PARENT_PADDING)
                    bottom.linkTo(parent.bottom, ARTICLE_ITEM_PARENT_PADDING)
                }
            )
        }
    }
}

@Preview
@Composable
fun ArticleItemPreview() {
    val articleItem = ArticleItemModel(
        id = 0,
        title = "Launching a weight loss startup and knowing when to pivot",
        author = "Brian Heater",
        description = "Swathy Prithivi speaks modestly about her years at Uber and Opendoor, but her role as manager at those powerhouse firms made her well-positioned to set out founding her own startup. Atomic VC was there from the outset, with a unique approach to early stage in…",
        publishedAt = "2022-08-10T13:58:20Z",
        url = "",
        urlToImage = ""
    )
    ArticleItem(
        articleItem = articleItem,
        onClick = {}
    )
}
