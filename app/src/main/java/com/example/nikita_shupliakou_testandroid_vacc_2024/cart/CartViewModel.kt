package com.example.nikita_shupliakou_testandroid_vacc_2024.cart

import androidx.lifecycle.ViewModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.DetailsModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.repository.CartRepository
import com.example.nikita_shupliakou_testandroid_vacc_2024.repository.StoreRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val storeRepository: StoreRepository,
    private val cartRepository: CartRepository,
):ViewModel() {
    val errorFlow = MutableSharedFlow<Throwable>()

    val nowState = MutableStateFlow(ListUIState(cartList = listOf(), false))


//    init {
//        viewModelScope.launch {
//            runCatching {
//                nowState.value = ListUIState(cartList = listOf(), isLoading = true)
//                delay(1000)
//                cartRepository.getDetails()
//            }.onSuccess { productList ->
//                nowState.value =
//                    ListUIState(cartList = productList, isLoading = false)
//            }.onFailure { error ->
//                errorFlow.emit(error)
//                nowState.value = ListUIState(cartList = listOf(), isLoading = false)
//            }
//        }
//    }

    data class ListUIState(
        val cartList: List<DetailsModel>,
        val isLoading: Boolean,
    )
}