package com.geektech.taskmanager.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.taskmanager.databinding.ItemOnBoardingBinding
import com.geektech.taskmanager.model.OnBoard
import com.geektech.taskmanager.utils.loadImage

class OnBoardingAdapter(private val onStartClick:()->Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf<OnBoard>(
        OnBoard(
             "Availability",
            "Our app is always near you",
            "https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"
        ),
        OnBoard(
            "Productivity",
            "Your day becomes planned and productive",
            "https://img.freepik.com/free-vector/accept-tasks-concept-illustration_114360-4492.jpg"
        ),
        OnBoard(
            "Made by those who use",
            "Made with love!",
            "https://miro.medium.com/max/1400/1*8ygFKYb0Yo6Hc-vnScGA9A.png"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {

            binding.btnStart.setOnClickListener {
                onStartClick()
            }
            binding.btnSkip.setOnClickListener {
                onStartClick()
            }

            binding.btnStart.isVisible = adapterPosition == 2
            binding.btnSkip.isVisible = adapterPosition != 2

            binding.tittle.text = onBoard.tittle
            binding.description.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image.toString())
        }

    }

}