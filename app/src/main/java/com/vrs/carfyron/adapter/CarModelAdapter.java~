package com.vrs.carfyron.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vrs.carfyron.model.ModelCarDetails;

import java.util.ArrayList;

/**
 * Class Name: CarModelAdapter
 * Description:A adapter class which trigger RecyclerView to add the view
 * Extends: RecyclerView.Adapter
 * Created by vrs on 27/3/15.
 */
public class CarModelAdapter extends RecyclerView.Adapter<CarModelAdapter.CarModelItemHolder> {

    private Context mContext;
    private ArrayList<ModelCarDetails> mModelDataSet;


    public CarModelAdapter(Context mContext, ArrayList<ModelCarDetails> mModelDataSet) {
        this.mContext = mContext;
        this.mModelDataSet = mModelDataSet;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 * 2; //return 0 or 2, decide which item layout you use
    }

    @Override
    public CarModelItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = null;
        switch (i) {
            case 0:
//                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
// .list_item_carmodel_1, viewGroup, false);
                break;

            case 2:
//                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
// .list_item_carmodel_2, viewGroup, false);
                break;
        }

        return new CarModelItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CarModelItemHolder carModelItemHolder, int i) {
        carModelItemHolder.tvModelName.setText(mModelDataSet.get(i).getModel());
        carModelItemHolder.tvModelPrice.setText(mModelDataSet.get(i).getPrice());
        carModelItemHolder.ivModelImage.setImageResource(mModelDataSet.get(i).getImage());

        carModelItemHolder.setOnHolderItemClickListener(new OnHolderItemClickListener() {
            @Override
            public void onHolderItemClick(View v, int position) {
//                Intent inetDetails = new Intent(mContext, ModelDetails.class);
//                inetDetails.putExtra(Helper.KEY_MODEL_DETAILS, mModelDataSet.get(position));
//                ActivityOptionsCompat options = ActivityOptionsCompat
// .makeSceneTransitionAnimation((Activity) mContext, (View) carModelItemHolder.ivModelImage,
// "robot");
//                mContext.startActivity(inetDetails, options.toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return mModelDataSet.size();
    }


    /**
     * Class Name: CarModelItemHolder
     * Description:Provide reference to the view for each data item
     * Extends: RecyclerView.ViewHolder
     * Created by vrs on 27/3/15.
     */
    public class CarModelItemHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener {

        protected TextView tvModelName;
        protected TextView tvModelPrice;
        protected ImageView ivModelImage;

        OnHolderItemClickListener listener;

        public CarModelItemHolder(View itemView) {
            super(itemView);

//            tvModelName = (TextView) itemView.findViewById(R.id.tv_list_item_carmodel_name);
//            tvModelPrice = (TextView) itemView.findViewById(R.id.tv_list_item_carmodel_price);
//            ivModelImage = (ImageView) itemView.findViewById(R.id.iv_list_item_carmodel_image);

            itemView.setOnClickListener(this);
        }


        public void setOnHolderItemClickListener(OnHolderItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onHolderItemClick(v, getPosition());

        }


    }

    public interface OnHolderItemClickListener {
        public void onHolderItemClick(View v, int position);
    }

}
