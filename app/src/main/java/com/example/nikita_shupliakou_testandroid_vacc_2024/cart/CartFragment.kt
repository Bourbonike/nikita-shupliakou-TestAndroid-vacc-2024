package com.example.nikita_shupliakou_testandroid_vacc_2024.cart

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nikita_shupliakou_testandroid_vacc_2024.R
import com.example.nikita_shupliakou_testandroid_vacc_2024.databinding.FragmentCartBinding
import com.example.nikita_shupliakou_testandroid_vacc_2024.details.DetailsFragment
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import javax.inject.Inject


class CartFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: FragmentCartBinding

    private val viewModel: CartViewModel by viewModels { viewModelFactory }
    private val adapter = CartAdapter(onItemClicked = { productListModel ->
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, DetailsFragment().apply {
                arguments = bundleOf("ID" to productListModel.id)
            }
            )
            .addToBackStack(null)
            .commit()
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(layoutInflater)
        viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewMain = binding.rvProducts
        recyclerViewMain.layoutManager = GridLayoutManager(context, 2)
        recyclerViewMain.adapter = adapter

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nowState.collect { nowState ->
//                    adapter.setCartList(nowState.cartList)
                    binding.progress.visibility = if (nowState.isLoading) {
                        View.VISIBLE
                    } else {
                        View.INVISIBLE
                    }
                }
            }
        }
//        view.findViewById<TextView>(R.id.testMenuTextView).text = viewModel.testString
        lifecycleScope.launch {
            viewModel.errorFlow.collect { exception ->
                val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                builder
                    .setMessage(getString(R.string.request_failed_message))
                    .setTitle(getString(R.string.request_failed_title))
                    .setPositiveButton(getString(R.string.ok)) { _, _ -> }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }


}