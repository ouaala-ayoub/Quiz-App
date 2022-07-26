package com.example.autofilala.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.R
import com.example.autofilala.databinding.SingleExplanationBinding
import com.example.autofilala.modules.ExplanationBlock

const val maxNumOfSeries = 15

class ExplanationAdapter(
    private val explanationList: List<ExplanationBlock>
): RecyclerView.Adapter<ExplanationAdapter.ExplanationHolder>() {

    companion object{
        private const val MARGIN_SIZE = 20
    }

    inner class ExplanationHolder(val binding: SingleExplanationBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplanationHolder {

        val cardWidth = (parent.width / 3) - (2* MARGIN_SIZE)
        val cardHeight = (parent.height / 4)- (2* MARGIN_SIZE)

        val view = SingleExplanationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val layoutParams = view.singleExpl.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardWidth
        layoutParams.height = cardHeight
        layoutParams.setMargins(MARGIN_SIZE, 2*MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ExplanationHolder(view)
    }

    override fun onBindViewHolder(holder: ExplanationHolder, position: Int) {
        val res = holder.binding.root.context.resources
        holder.binding.apply {
            val block = explanationList[position]

            if (position <= maxNumOfSeries)
                explSerieNum.text = res.getString(R.string.expl_serie_number, block.number)
            else
                explSerieNum.text = block.text

            num.text = block.number.toString()
        }
    }

    override fun getItemCount() = explanationList.size

}