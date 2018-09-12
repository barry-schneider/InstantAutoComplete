package com.msih.instantautocomplete;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class InstantAutoComplete extends AutoCompleteTextView {

    private boolean showAlways;

    public InstantAutoComplete(Context context) {
        super(context);
    }

    public InstantAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InstantAutoComplete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public InstantAutoComplete(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setShowAlways(boolean showAlways) {
        this.showAlways = showAlways;
    }

    @Override
    public boolean enoughToFilter() {
        return showAlways || super.enoughToFilter();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);

        showDropDownIfFocused();
    }

    private void showDropDownIfFocused() {
        if (enoughToFilter() && isFocused() && getWindowVisibility() == View.VISIBLE) {

            showDropDown();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        showDropDownIfFocused();
    }
}
