package com.vrs.carfyron.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vrs.carfyron.R;
import com.vrs.carfyron.iface.NavigationDrawerCallbacks;
import com.vrs.carfyron.model.NavigationItem;

import java.util.List;

/**
 * Created by poliveira on 24/10/2014.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter
        .ViewHolder> {

    private List<NavigationItem> mData;
    private NavigationDrawerCallbacks mNavigationDrawerCallbacks;
    private int mSelectedPosition;
    private int mTouchedPosition = -1;

    public NavigationDrawerAdapter(List<NavigationItem> data) {
        mData = data;
    }

    public NavigationDrawerCallbacks getNavigationDrawerCallbacks() {
        return mNavigationDrawerCallbacks;
    }

    public void setNavigationDrawerCallbacks(NavigationDrawerCallbacks navigationDrawerCallbacks) {
        mNavigationDrawerCallbacks = navigationDrawerCallbacks;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                .list_item_car_drawer, viewGroup, false);
        final ViewHolder viewholder = new ViewHolder(v);
        viewholder.itemView.setOnTouchListener(new View.OnTouchListener() {
                                                   @Override
                                                   public boolean onTouch(View v,
                                                                          MotionEvent event) {

                                                       switch (event.getAction()) {
                                                           case MotionEvent.ACTION_DOWN:
                                                               touchPosition(viewholder
                                                                       .getAdapterPosition());
                                                               if (mNavigationDrawerCallbacks !=
                                                                       null)
                                                                   mNavigationDrawerCallbacks
                                                                           .onNavigationDrawerItemSelected
                                                                                   (viewholder
                                                                                           .getAdapterPosition());


                                                               return false;
                                                           case MotionEvent.ACTION_CANCEL:
                                                               touchPosition(-1);
                                                               if (mNavigationDrawerCallbacks !=
                                                                       null)
                                                                   mNavigationDrawerCallbacks
                                                                           .onNavigationDrawerItemSelected
                                                                                   (viewholder
                                                                                           .getAdapterPosition());
                                                               return false;
                                                           case MotionEvent.ACTION_MOVE:
                                                               if (mNavigationDrawerCallbacks !=
                                                                       null)
                                                                   mNavigationDrawerCallbacks
                                                                           .onNavigationDrawerItemSelected
                                                                                   (viewholder
                                                                                           .getAdapterPosition());
                                                               return false;
                                                           case MotionEvent.ACTION_UP:
                                                               if (mNavigationDrawerCallbacks !=
                                                                       null)
                                                                   mNavigationDrawerCallbacks
                                                                           .onNavigationDrawerItemSelected
                                                                                   (viewholder
                                                                                           .getAdapterPosition());
                                                               touchPosition(-1);
                                                               return false;
                                                       }
                                                       return true;
                                                   }
                                               }
        );
//        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
//                                                   @Override
//                                                   public void onClick(View v) {
//                                                       if (mNavigationDrawerCallbacks != null)
//                                                           mNavigationDrawerCallbacks
//                                                                   .onNavigationDrawerItemSelected
//                                                                           (viewholder
//
// .getAdapterPosition());
//                                                   }
//                                               }
//        );
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(mData.get(i).getText());
        viewHolder.ivBrandLogo.setImageResource(mData.get(i).getDrawable());

//        //selected menu position, change layout accordingly
//        if (mSelectedPosition == i || mTouchedPosition == i) {
//            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext()
// .getResources().getColor(R.color.lightColorTextSecondary));
//        } else {
//            viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT);
//        }
    }

    private void touchPosition(int position) {
        int lastPosition = mTouchedPosition;
        mTouchedPosition = position;
        if (lastPosition >= 0)
            notifyItemChanged(lastPosition);
        if (position >= 0)
            notifyItemChanged(position);
    }

    public void selectPosition(int position) {
        int lastPosition = mSelectedPosition;
        mSelectedPosition = position;
        notifyItemChanged(lastPosition);
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView ivBrandLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.list_item_tv_brand_name);
            ivBrandLogo = (ImageView) itemView.findViewById(R.id.list_item_brand_image);
        }
    }
}
