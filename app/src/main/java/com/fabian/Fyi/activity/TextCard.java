package com.fabian.Fyi.activity;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.fabian.Fyi.R;

public class TextCard extends CardView {

    public TextCard(@NonNull Context context) {
        super(context);
    }

    public TextCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
