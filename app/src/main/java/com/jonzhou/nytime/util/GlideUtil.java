package com.jonzhou.nytime.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by jon on 12/16/17.
 */

public class GlideUtil {
    public static void showImageView(Context context, String path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

}