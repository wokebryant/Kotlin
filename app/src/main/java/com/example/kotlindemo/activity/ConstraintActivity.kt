package com.example.kotlindemo.activity

import android.os.Bundle
import com.example.kotlindemo.R

class ConstraintActivity : TransformActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        testPlaceHolder()
    }

    /**
     * 占位符
     */
    private fun testPlaceHolder() {
//        placeholder.setContentId(R.id.button)
    }


}