package com.example.autofilala.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofilala.R
import com.example.autofilala.adapters.ExplanationAdapter
import com.example.autofilala.modules.ExplanationBlock

class ExplanationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explanation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val explRecyclerView = view.findViewById<RecyclerView>(R.id.explanationRv)
        explRecyclerView.adapter = ExplanationAdapter(listOf(
            ExplanationBlock("test", 1),
            ExplanationBlock("test", 2),
            ExplanationBlock("test", 3),
            ExplanationBlock("test", 4),
            ExplanationBlock("test", 5),
            ExplanationBlock("test", 6),
            ExplanationBlock("test", 7),
            ExplanationBlock("test", 8),
            ExplanationBlock("test", 9),
            ExplanationBlock("test", 10),
            ExplanationBlock("test", 11)
        ))
        explRecyclerView.layoutManager = GridLayoutManager(activity, 3)
    }
}