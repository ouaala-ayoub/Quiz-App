package com.example.autofilala.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.R
import com.example.autofilala.activities.SerieActivity
import com.example.autofilala.databinding.SingleSerieBinding
import com.example.autofilala.modules.Serie
import com.example.autofilala.modules.Status

class SeriesAdapter(
    private val seriesList: List<Serie>,
    private val context: Context?
): RecyclerView.Adapter<SeriesAdapter.SeriesHolder>(){

    companion object{
        const val MARGIN_SIZE = 20
    }

    inner class SeriesHolder(val binding: SingleSerieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int): String{
            val res = binding.root.context.resources
            binding.apply {
                val serie = seriesList[position]

                //set the result test
                result.text = res.getString(R.string.results, serie.score)

                //set the serie number text
                serieNum.text = res.getString(R.string.serie_number, serie.number)

                //set the serie number
                serieNumber.text = serie.number.toString()

                //checked image to implement
                if(serie.status == Status.CHECKED){
                    checkedDownload.setImageResource(R.drawable.download_check)
                }
                else{
                    checkedDownload.setImageResource(R.drawable.download)
                }
            }
            return binding.serieNum.text.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesHolder {

        val cardWidth = parent.width / 2 - (2 * MARGIN_SIZE)
        val cardHeight = parent.height / 5 - (2 * MARGIN_SIZE)

        val view = SeriesHolder(SingleSerieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
        val layoutParams = view.binding.singleSerieQuest.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardWidth
        layoutParams.height = cardHeight
        layoutParams.setMargins(MARGIN_SIZE, 2*MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return view
    }

    override fun onBindViewHolder(holder: SeriesHolder, position: Int) {

        //binding the view
        val serieTitle = holder.bind(position)

        //setting the click listener
        holder.binding.singleSerieQuest.setOnClickListener {
            val intent = Intent(context, SerieActivity::class.java)
            intent.putExtra("serie_number", seriesList[position].number)
            intent.putExtra("serie_title", serieTitle)
            context?.startActivity(intent)
        }

    }

    override fun getItemCount() = seriesList.size
}