package com.example.nikita_shupliakou_testandroid_vacc_2024.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.ProductListModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.repository.StoreRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val storeRepository: StoreRepository
) : ViewModel() {
    val errorFlow = MutableSharedFlow<Throwable>()

    val nowState = MutableStateFlow(ListUIState(productList = listOf(), false))


    init {
        viewModelScope.launch {
            runCatching {
                nowState.value = ListUIState(productList = listOf(), isLoading = true)
                delay(1000)
                storeRepository.getProducts()
            }.onSuccess { productList ->
                nowState.value =
                    ListUIState(productList = productList, isLoading = false)
            }.onFailure { error ->
                errorFlow.emit(error)
                nowState.value = ListUIState(productList = listOf(), isLoading = false)
            }
        }
    }

    data class ListUIState(
        val productList: List<ProductListModel>,
        val isLoading: Boolean,
    )
}