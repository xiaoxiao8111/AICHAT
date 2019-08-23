package com.xiaoxiao.commoncore.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {

    public static void loadRoundedCenterCropUrl(Context context, ImageView imageView, String url, int radius) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(imageView);
    }
}
