package com.example.autofilala.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.R
import com.example.autofilala.modules.Theory
import com.example.autofilala.adapters.TheoryAdapter


class TheoryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_theory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val theoryView = view.findViewById<RecyclerView>(R.id.theory_recycler)

        theoryView.adapter = TheoryAdapter(listOf(
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
            Theory("test"),
        ))
        theoryView.layoutManager = GridLayoutManager(activity, 2)
    }
}