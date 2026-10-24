package com.bbp.crashtower.listener;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.View;

public class LongClickListener implements View.OnLongClickListener {
    public boolean onLongClick(View view) {
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
        String[] mimeType={ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data= new ClipData(view.getTag().toString(),mimeType,item);
        View.DragShadowBuilder shadowBuilder =new View.DragShadowBuilder(view);
        view.startDrag(data,shadowBuilder,view,0);
        view.setVisibility(View.INVISIBLE);
        return true;
    }
}
