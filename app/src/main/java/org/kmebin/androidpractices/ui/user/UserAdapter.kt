package org.kmebin.androidpractices.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.kmebin.androidpractices.R
import org.kmebin.androidpractices.data.model.Data
import org.kmebin.androidpractices.databinding.ItemUserBinding

class UserAdapter(
    private val user: List<Data>,
    private val listener: RecyclerviewClickListener
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(
        val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            DataBindingUtil.inflate<ItemUserBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_user,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.user = user[position]
        holder.binding.root.setOnClickListener {
            listener.onItemClick(holder.binding.root, user[position])
        }
    }

    override fun getItemCount() = user.size
}