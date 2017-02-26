package com.alexsantos.foodmenucollegeproject;

/**
 * Created by Alex on 26/02/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexsantos.foodmenucollegeproject.model.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataProductAdapter extends RecyclerView.Adapter<DataProductAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY ="item_id" ;
    private List<Product> mItems;
    private Context mContext;

    public DataProductAdapter(Context context, List<Product> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public DataProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mContext);
        boolean grid = settings.getBoolean(mContext.getString(R.string.pref_display_in_grid),false);

        int layoutId = grid ? R.layout.grid_item : R.layout.product_list;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataProductAdapter.ViewHolder holder, int position) {
        final Product item = mItems.get(position);

        try {
            holder.tvName.setText(item.getProductName());
            String imageFile = item.getImage();
            InputStream inputStream = mContext.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itemId = item.getProductId();
                Intent i = new Intent(mContext,DetailActivity.class);
                i.putExtra(ITEM_ID_KEY,itemId);
                mContext.startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ImageView imageView;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.itemNameText);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            mView = itemView;
        }
    }
}

