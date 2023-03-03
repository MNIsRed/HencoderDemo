package com.mole.hencoderdemo

import android.util.ArrayMap

class Lessons {
    companion object{
        val LESSON_LIST = ArrayList<LessonDTO>(0).apply {
            add(LessonDTO("文字测量","action_LessonsFragment_to_DrawTextFragment"))
        }
    }

    data class LessonDTO(val name: String,val action:String)
}