package com.example.nikita_shupliakou_testandroid_vacc_2024.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.DetailsModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.repository.StoreRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val storeRepository: StoreRepository,
) : ViewModel() {
    val errorFlow = MutableSharedFlow<Throwable>()

    val nowState = MutableStateFlow(DetailsUIState(productList = null, false))


    fun setProductDetails(id:Int) {
        viewModelScope.launch {
            runCatching {
                nowState.value = DetailsUIState(
                    productList = null, isLoading = true
                )
                delay(1000)
                storeRepository.getDetails(id)
            }.onSuccess { productList ->
                nowState.value =
                    DetailsUIState(productList = productList, isLoading = false)
            }.onFailure { error ->
                errorFlow.emit(error)
                nowState.value = DetailsUIState(productList = null, isLoading = false)
            }
        }
    }

    data class DetailsUIState(
        val productList: DetailsModel?,
        val isLoading: Boolean,
    )
}