package com.mole.hencoderdemo

import android.content.Context

class Lessons {

    lateinit var LESSON_LIST : ArrayList<LessonDTO>

    fun getLessons(context:Context):ArrayList<LessonDTO>{
        if (this::LESSON_LIST.isInitialized){
            return LESSON_LIST
        }else{
            return ArrayList<LessonDTO>().apply{
                add(LessonDTO(context.getString(R.string.dash_fragment_label),"action_LessonsFragment_to_DashFragment"))
                add(LessonDTO(context.getString(R.string.avatar_fragment_label),"action_LessonsFragment_to_AvatarFragment"))
                add(LessonDTO(context.getString(R.string.draw_text_fragment_label),"action_LessonsFragment_to_DrawTextFragment"))
                add(LessonDTO(context.getString(R.string.camera_fragment_label),"action_LessonsFragment_to_CameraFragment"))
                LESSON_LIST = this
            }
        }

    }

    data class LessonDTO(val name: String,val action:String)
}