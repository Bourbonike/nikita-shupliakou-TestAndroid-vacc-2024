package com.example.nikita_shupliakou_testandroid_vacc_2024.details

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.nikita_shupliakou_testandroid_vacc_2024.R
import com.example.nikita_shupliakou_testandroid_vacc_2024.databinding.FragmentDetailsBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: FragmentDetailsBinding

    //    val viewModel by lazy {
//        ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
//    }
    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id: Int? = arguments?.getInt("ID")
//        viewModel.setProductDetails(id = intent.getIntExtra(MOVIE_ID_KEY, 0))
//        view.findViewById<TextView>(R.id.testMenuTextView).text = viewModel.testString
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nowState.collect { productState ->
                    binding.toolbar.title = productState.productList?.title
                    productState.productList?.description?.let { description ->
                        binding.description.text = description
                    }
                    productState.productList?.price?.let { price ->
                        binding.productPrice.text = price.toString()
                    }

                    productState.productList?.rating?.rate?.let { rate ->
                        binding.rate.text =
                            resources.getString(R.string.rate_template) + rate.toString()
                    }
                    productState.productList?.rating?.count?.let { count ->
                        binding.count.text =
                            resources.getString(R.string.count_template) + count.toString()
                    }
                    context?.let {
                        Glide.with(it)
                            .load(viewModel.nowState.value.productList?.image)
                            .into(binding.toolbarImage)
                    }
                    binding.rate.visibility = if (productState.isLoading) {
                        View.INVISIBLE
                    } else {
                        View.VISIBLE
                    }
                    binding.count.visibility = if (productState.isLoading) {
                        View.INVISIBLE
                    } else {
                        View.VISIBLE
                    }
                    binding.money.visibility = if (productState.isLoading) {
                        View.INVISIBLE
                    } else {
                        View.VISIBLE
                    }
                    binding.progress.visibility = if (productState.isLoading) {
                        View.VISIBLE
                    } else {
                        View.INVISIBLE
                    }
                    binding.addToCart.visibility = if (productState.isLoading) {
                        View.INVISIBLE
                    } else {
                        View.VISIBLE
                    }
                }
            }
        }
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
        if (id != null) {
            viewModel.setProductDetails(id = id.toInt())
        }
    }

}