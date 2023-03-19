package com.mole.hencoderdemo

import android.content.Context

class Lessons {

    private lateinit var LESSON_LIST : ArrayList<LessonDTO>
    fun getLessons(context:Context):ArrayList<LessonDTO>{
        return if (this::LESSON_LIST.isInitialized){
            LESSON_LIST
        }else{
            ArrayList<LessonDTO>().apply{
                add(LessonDTO(context.getString(R.string.dash_fragment_label),"action_LessonsFragment_to_DashFragment"))
                add(LessonDTO(context.getString(R.string.avatar_fragment_label),"action_LessonsFragment_to_AvatarFragment"))
                add(LessonDTO(context.getString(R.string.draw_text_fragment_label),"action_LessonsFragment_to_DrawTextFragment"))
                add(LessonDTO(context.getString(R.string.camera_fragment_label),"action_LessonsFragment_to_CameraFragment"))
                add(LessonDTO(context.getString(R.string.animation_fragment_label),"action_LessonsFragment_to_AnimationFragment"))
                add(LessonDTO(context.getString(R.string.custom_drawable_fragment_label),"action_LessonsFragment_to_CustomDrawableFragment"))
                add(LessonDTO(context.getString(R.string.material_edit_text_fragment_label),"action_LessonsFragment_to_MaterialEditTextFragment"))
                LESSON_LIST = this
            }
        }

    }

    data class LessonDTO(val name: String,val action:String)
}