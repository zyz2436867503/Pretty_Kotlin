package com.example.kotlin.utils

import android.text.TextUtils
import android.widget.TextView

object TxtUtils {
    fun setTextView(textView: TextView?, word: String?) {
        if (textView != null && !TextUtils.isEmpty(word)) {
            textView.text = word
        }
    } /*//手势
    public static void setPhotoView(Context context, PhotoView photoView, String image) {
        if (photoView != null && !TextUtils.isEmpty(image)) {
            Glide.with(context).load(image)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                    .into(photoView);
        }
    }*/
}