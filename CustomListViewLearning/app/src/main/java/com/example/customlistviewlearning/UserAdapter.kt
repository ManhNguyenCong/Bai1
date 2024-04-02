package com.example.customlistviewlearning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.customlistviewlearning.databinding.ItemListUsersBinding

class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(DiffCallback) {
    class UserViewHolder(private val binding: ItemListUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.tvName.text = user.name
            binding.tvAge.text = String.format("%d tuổi", user.age)
            binding.tvMale.text = if (user.male) {
                "Nam"
            } else {
                "Nữ"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemListUsersBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_list_users, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.male == newItem.male &&
                        oldItem.age == newItem.age
            }
        }
    }
}