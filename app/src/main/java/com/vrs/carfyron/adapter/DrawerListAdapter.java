package com.vrs.carfyron.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vrs.carfyron.R;
import com.vrs.carfyron.model.ModelBrand;

import java.util.ArrayList;

/**
 * Class Name: DrawerListAdapter
 * Description: Provide view for the each data item, bind data list to the list view
 * Extends: BaseAdapter
 * Created by vrs on 31/3/15.
 */
public class DrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ModelBrand> brand;
    private int resource;
    private LayoutInflater inflater;


    public DrawerListAdapter(Context context, ArrayList<ModelBrand> brand, int resource) {
        this.context = context;
        this.brand = brand;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return brand.size();
    }

    @Override
    public Object getItem(int position) {
        return brand.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = (LinearLayout) inflater.inflate(resource, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.ivBrand.setImageResource(brand.get(position).getmBrandLogoId());
        vh.tvBrand.setText(brand.get(position).getmBrandName());

        return convertView;
    }

    /**
     * Class Name: ViewHolder
     * Description:Used for view caching of all data item, holds the view of all child widget in
     * list item
     * Created by vrs on 31/3/15.
     */

    private class ViewHolder {
        public ImageView ivBrand;
        public TextView tvBrand;

        private ViewHolder(View view) {
            this.ivBrand = (ImageView) view.findViewById(R.id.list_item_brand_image);
            this.tvBrand = (TextView) view.findViewById(R.id.list_item_tv_brand_name);
        }
    }
}
