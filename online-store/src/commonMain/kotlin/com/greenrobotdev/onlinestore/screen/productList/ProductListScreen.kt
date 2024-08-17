package com.greenrobotdev.onlinestore.screen.productList

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.greenrobotdev.core.utils.statusBarPadding
import com.greenrobotdev.onlinestore.domain.entity.Product
import com.greenrobotdev.onlinestore.ui.ProductItem
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
fun ProductListScreen(
    onProductSelect: (product: Product) -> Unit,
    wishlistSelect: () -> Unit,
    cartSelected: () -> Unit,
) {

    val viewModel: ProductListViewModel =
        rememberOnRoute(ProductListViewModel::class) { savedState ->
            ProductListViewModel(savedState)
        }

    val state: ProductListState by viewModel.states.collectAsState()
    ProductListView(
        state = state,
        onProductSelect = onProductSelect,
        isRefreshing = state.isRefreshing,
        onRefresh = { viewModel.onRefresh() },
        onWishListPressed = wishlistSelect,
        onCartPressed = cartSelected,
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListView(
    state: ProductListState,
    onProductSelect: (product: Product) -> Unit,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    onWishListPressed: () -> Unit,
    onCartPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Online Store")
                },
                actions = {

                    IconButton(onClick = onWishListPressed) {
                        BadgedBox(
                            badge = {
                                if (state.numberOfFavorite > 0)
                                    Badge {
                                        Text(state.numberOfFavorite.toString())
                                    }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorite"
                            )
                        }
                    }
                    IconButton(onClick = onCartPressed) {
                        BadgedBox(
                            badge = {
                                if (state.numberOfCartProducts > 0) {
                                    Badge {
                                        Text(state.numberOfCartProducts.toString())
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Cart"
                            )
                        }
                    }
                },
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.statusBarPadding)
            )
        },
        modifier = Modifier
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .scrollable(rememberScrollState(), Orientation.Vertical)
                .fillMaxSize()
                .padding(scaffoldPadding)
        ) {

            when {
                state.hasError == true -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text("Something is wrong. Try again later.")

                        Button(onClick = onRefresh) {
                            Text("Retry")
                        }
                    }
                }

                state.products == Loading -> Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                state.products != Loading -> ProductList(
                    products = state.products,
                    onRefresh = onRefresh,
                    isRefreshing = state.isRefreshing,
                    onProductSelect = onProductSelect
                ) {
                    ProductItem(
                        item = it,
                        onProductSelect = onProductSelect
                    )
                }
            }
        }
    }
}
//
//@Composable
//fun ProductList(
//    products: List<Product>,
//    onProductSelect: (product: Product) -> Unit,
//) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize()
//    ) {
//        items(products) {
//            ProductItem(
//                item = it,
//                onProductSelect = onProductSelect
//            )
//        }
//    }
//
//}

