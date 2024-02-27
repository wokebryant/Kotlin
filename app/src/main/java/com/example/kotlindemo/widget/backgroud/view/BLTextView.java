package com.example.kotlindemo.widget.backgroud.view;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.example.kotlindemo.widget.backgroud.BackgroundFactory;

public class BLTextView extends AppCompatTextView {
    public BLTextView(Context context) {
        super(context);
    }

    public BLTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BLTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        BackgroundFactory.setViewBackground(context, attrs, this);
    }
}
