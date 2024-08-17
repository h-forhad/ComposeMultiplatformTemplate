package com.greenrobotdev.onlinestore.screen.productList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.greenrobotdev.onlinestore.domain.entity.Product
import java.lang.reflect.Modifier

@Composable
actual fun ProductList(
    products: List<Product>,
    onRefresh: () -> Unit,
    isRefreshing : Boolean,
    onProductSelect: (product: Product) -> Unit,
    block: @Composable (product: Product) -> Unit,
){

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = onRefresh
    ){
        LazyVerticalStaggeredGrid(
            state = rememberLazyStaggeredGridState(),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            columns = StaggeredGridCells.Adaptive(160.dp),
        ) {
            items(products) { product -> block(product) }
        }
    }
}
