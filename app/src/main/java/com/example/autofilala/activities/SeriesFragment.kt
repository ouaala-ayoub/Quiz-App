package com.example.autofilala.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.R
import com.example.autofilala.modules.Serie
import com.example.autofilala.adapters.SeriesAdapter
import com.example.autofilala.databinding.FragmentSeriesBinding


class SeriesFragment : Fragment() {

    private lateinit var binding: FragmentSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        //binding = FragmentSeriesBinding.inflate(layoutInflater)

        val seriesRecycler = view.findViewById<RecyclerView>(R.id.series_recycler)

        //network call for the series

        seriesRecycler.adapter = SeriesAdapter(listOf(
            Serie(1),
            Serie(2),
            Serie(3),
            Serie(4),
            Serie(5),
            Serie(6),
            Serie(7),
            Serie(8),
            Serie(9),
            Serie(10),
            Serie(11),
            Serie(12),
            Serie(13)
        ), this.context)
        seriesRecycler.layoutManager = GridLayoutManager(activity, 2)
        seriesRecycler.setHasFixedSize(true)
    }
}