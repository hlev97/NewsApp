package hu.bme.aut.android.newsapp.ui.screen.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.android.newsapp.R
import hu.bme.aut.android.newsapp.navigation.model.Business
import hu.bme.aut.android.newsapp.navigation.model.Popular
import hu.bme.aut.android.newsapp.navigation.model.Science
import hu.bme.aut.android.newsapp.navigation.model.Sport
import hu.bme.aut.android.newsapp.ui.screen.main.model.NavItemModel

@Composable
fun MainScreenBottomNavigation(
    navItems: List<NavItemModel>,
    onClick: (Int) -> Unit
) {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, navItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = stringResource(id = navItem.label)
                    )
                },
                label = if (selectedItem == index) {
                    null
                } else {
                    {
                        Text(text = stringResource(id = navItem.label))
                    }
                },
                selected = index == selectedItem,
                onClick = {
                    selectedItem = index
                    onClick(selectedItem)
                }
            )
        }
    }
}

@Composable
@Preview
fun MainScreenBottomNavigationPreview() {
    val navItems = listOf(
        NavItemModel(
            icon = Icons.Filled.Star,
            label = R.string.nav_item_popular_news_label,
            route = Popular.route
        ),
        NavItemModel(
            icon = Icons.Filled.Sports,
            label = R.string.nav_item_popular_news_sport_label,
            route = Sport.route
        ),
        NavItemModel(
            icon = Icons.Filled.Science,
            label = R.string.nav_item_popular_news_science_label,
            route = Science.route
        ),
        NavItemModel(
            icon = Icons.Filled.Business,
            label = R.string.nav_item_popular_news_business_label,
            route = Business.route
        )
    )
    MainScreenBottomNavigation(
        navItems = navItems,
        onClick = {}
    )
}
