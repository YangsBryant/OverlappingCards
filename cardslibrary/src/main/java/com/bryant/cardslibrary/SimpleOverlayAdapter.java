package com.bryant.cardslibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.request.RequestOptions;

public class SimpleOverlayAdapter extends BaseOverlayPageAdapter {

    private LayoutInflater mInflater;

    public SimpleOverlayAdapter(Context context, Drawable error,Drawable load) {
        super(context, new RequestOptions().error(error).placeholder(load));
        mInflater = LayoutInflater.from(context);
    }

    public SimpleOverlayAdapter(Context context) {
        super(context,  new RequestOptions());
        mInflater = LayoutInflater.from(context);
    }



    @Override
    protected View itemView() {
        return mInflater.inflate(R.layout.item_viewpager, null);
    }


}
