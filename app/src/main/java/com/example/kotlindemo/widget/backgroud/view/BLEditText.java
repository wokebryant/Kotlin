package com.example.kotlindemo.widget.backgroud.view;

import android.content.Context;
import androidx.appcompat.widget.AppCompatEditText;
import android.util.AttributeSet;
import com.example.kotlindemo.widget.backgroud.BackgroundFactory;

public class BLEditText extends AppCompatEditText {
    public BLEditText(Context context) {
        super(context);
    }

    public BLEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BLEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        BackgroundFactory.setViewBackground(context, attrs, this);
    }
}
