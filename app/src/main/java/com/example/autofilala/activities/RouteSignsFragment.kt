package com.example.autofilala.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.R
import com.example.autofilala.modules.RouteSigns
import com.example.autofilala.adapters.RouteSignsAdapter

class RouteSignsFragment : Fragment() {

    companion object{
        //val text = Resources.getSystem().getString(R.string.route_signs)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_route_signs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val routeSignsRv = view.findViewById<RecyclerView>(R.id.routeSignsRv)
        val text = view.context.resources.getString(R.string.route_signs)

        routeSignsRv.setHasFixedSize(true)
        routeSignsRv.adapter = RouteSignsAdapter(listOf(
            RouteSigns(text),
            RouteSigns(text),
            RouteSigns(text),
            RouteSigns(text),
            RouteSigns(text),
            RouteSigns(text),
            RouteSigns(text),
        ))
        routeSignsRv.layoutManager = GridLayoutManager(activity, 2)

    }
}