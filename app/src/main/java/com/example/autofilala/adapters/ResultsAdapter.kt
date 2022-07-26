package com.example.autofilala.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.activities.CorrectionActivity
import com.example.autofilala.databinding.SingleResultBinding


class ResultsAdapter(
    private val context: Context?,
    private val resultsList: List<Boolean>,
    private var number: Int
): RecyclerView.Adapter<ResultsAdapter.ResultHolder>() {

    companion object {
        const val MARGIN_SIZE = 5
    }

    inner class ResultHolder(val binding: SingleResultBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {

        val buttonWidth = parent.width / 5 - 2 * MARGIN_SIZE
        val buttonHeight = parent.height / 8 - 2 * MARGIN_SIZE
        val view = SingleResultBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        val layoutParams = view.button.layoutParams as ViewGroup.MarginLayoutParams

        layoutParams.height = buttonHeight
        layoutParams.width = buttonWidth
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)

        return ResultHolder(view)
    }


    override fun onBindViewHolder(holder: ResultHolder, position: Int) {

        val greyColor = Color.GRAY

        holder.binding.button.apply {
            val resultNum = position + 1
            text = resultNum.toString()
            if (!resultsList[position]){
                setBackgroundColor(greyColor)
            }
        }

        holder.binding.button.setOnClickListener {
            val intent = Intent(context, CorrectionActivity::class.java)
            intent.putExtra("question_number", position)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount() = resultsList.size
}