package com.example.kotlindemo.widget.backgroud.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import com.example.kotlindemo.widget.backgroud.BackgroundFactory;

public class BLRadioGroup extends RadioGroup {
    public BLRadioGroup(Context context) {
        super(context);
    }

    public BLRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        BackgroundFactory.setViewBackground(context, attrs, this);
    }
}
