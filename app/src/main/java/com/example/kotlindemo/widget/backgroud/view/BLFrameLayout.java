package com.example.kotlindemo.widget.backgroud.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.example.kotlindemo.widget.backgroud.BackgroundFactory;

public class BLFrameLayout extends FrameLayout {
    public BLFrameLayout(Context context) {
        super(context);
    }

    public BLFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BLFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        BackgroundFactory.setViewBackground(context, attrs, this);
    }
}
