package com.example.autofilala.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.databinding.SignleRouteSignsBinding
import com.example.autofilala.modules.RouteSigns

class RouteSignsAdapter(
    private val routeList: List<RouteSigns>
): RecyclerView.Adapter<RouteSignsAdapter.RouteSignsHolder>() {

    inner class RouteSignsHolder(private val binding: SignleRouteSignsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.downloadImage.setImageResource(routeList[position].downloadImageRes)
            binding.routeSignsText.text = routeList[position].routeText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteSignsHolder {

        val cardWidth = parent.width / 2 - (2 * SeriesAdapter.MARGIN_SIZE)
        val cardHeight = parent.height / 3 - (2 * SeriesAdapter.MARGIN_SIZE)

        val view = SignleRouteSignsBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        val layoutParams = view.routeSignHolder.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardWidth
        layoutParams.height = cardHeight
        layoutParams.setMargins(
            SeriesAdapter.MARGIN_SIZE,
            2* SeriesAdapter.MARGIN_SIZE,
            SeriesAdapter.MARGIN_SIZE,
            SeriesAdapter.MARGIN_SIZE
        )

        return RouteSignsHolder(view)
    }

    override fun onBindViewHolder(holder: RouteSignsHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = routeList.size
}