package com.mole.hencoderdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mole.hencoderdemo.databinding.FragmentLessonBinding

class HenCoderLessonsRecyclerViewAdapter(
    private val values: List<Lessons.LessonDTO>
) : RecyclerView.Adapter<HenCoderLessonsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentLessonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.name
        holder.idView.setOnClickListener {
            holder.idView.apply {
                findNavController().navigate(
                    resources.getIdentifier(
                        item.action,
                        "id",
                        context.packageName
                    )
                )
            }
//            holder.idView.context.apply {
//                Navigation.createNavigateOnClickListener(resources.getIdentifier(item.action,"id",packageName))
//            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentLessonBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber

        override fun toString(): String {
            return super.toString() + " '"
        }
    }

}