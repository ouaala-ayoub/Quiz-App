package com.example.autofilala.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.databinding.SingleTheoryBinding
import com.example.autofilala.modules.Theory

class TheoryAdapter(private val listOfTheories: List<Theory>): RecyclerView.Adapter<TheoryAdapter.TheoryHolder>() {


    inner class TheoryHolder(val binding: SingleTheoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheoryHolder {

        val cardWidth = parent.width / 2 - (2 * SeriesAdapter.MARGIN_SIZE)
        val cardHeight = parent.height / 3 - (2 * SeriesAdapter.MARGIN_SIZE)

        val viewBinding = SingleTheoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val layoutParams = viewBinding.theoryCv.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardWidth
        layoutParams.height = cardHeight
        layoutParams.setMargins(
            SeriesAdapter.MARGIN_SIZE, 2 * SeriesAdapter.MARGIN_SIZE,
            SeriesAdapter.MARGIN_SIZE,
            SeriesAdapter.MARGIN_SIZE
        )
        return TheoryHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: TheoryHolder, position: Int) {
        val theory = listOfTheories[position]
        holder.binding.apply {
            theoryImage.setImageResource(theory.imageRes)
            theoryText.text = theory.text
        }
    }

    override fun getItemCount() = listOfTheories.size
}