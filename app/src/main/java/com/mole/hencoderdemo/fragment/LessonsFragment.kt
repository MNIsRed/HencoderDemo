package com.mole.hencoderdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mole.hencoderdemo.HenCoderLessonsRecyclerViewAdapter
import com.mole.hencoderdemo.Lessons
import com.mole.hencoderdemo.R

/**
 * A fragment representing a list of Items.
 */
class LessonsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lesson_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                val lessons = Lessons().getLessons(context)
                layoutManager = GridLayoutManager(context, lessons.size)
                adapter = HenCoderLessonsRecyclerViewAdapter(lessons)
            }
        }
        return view
    }


}