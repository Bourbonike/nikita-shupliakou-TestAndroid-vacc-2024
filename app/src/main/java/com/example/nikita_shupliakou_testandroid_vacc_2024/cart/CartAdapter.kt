package com.example.nikita_shupliakou_testandroid_vacc_2024.cart

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.nikita_shupliakou_testandroid_vacc_2024.databinding.ItemProductLayoutBinding
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.ProductListModel

class CartAdapter(


    private val onItemClicked: (ProductListModel) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private var productList = listOf<ProductListModel>()

    fun setCartList(productList: List<ProductListModel>) {
        this.productList = productList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemProductLayoutBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(productList[position].image)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            })
            .into(holder.binding.productImage)
        holder.binding.productName.text = productList[position].title
        holder.binding.root.setOnClickListener {
            onItemClicked(productList[position])
        }
    }

    override fun getItemCount(): Int = productList.size

    class ViewHolder(val binding: ItemProductLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}
