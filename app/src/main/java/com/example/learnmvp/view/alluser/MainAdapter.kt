package com.example.learnmvp.view.alluser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmvp.data.local.entity.UserEntity
import com.example.learnmvp.databinding.ItemUserBinding

class MainAdapter (private val listener : MainListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var listUser = mutableListOf<UserEntity>()

    fun updateUser(listUser: List<UserEntity>) {
        this.listUser = listUser as MutableList<UserEntity>
        notifyDataSetChanged()
    }

    class ViewHolder (private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserEntity){
            binding.tvId.text = user.id.toString()
            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemUserBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listUser[position])
        holder.itemView.setOnLongClickListener{
            toggleSelection(position)
            true
        }
    }

    private fun toggleSelection(position: Int) {




    }


    interface MainListener {

    }
}