package com.example.colorkid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorkid.Common.Common;
import com.example.colorkid.Interface.ImageOnClick;
import com.example.colorkid.PaintActivity;
import com.example.colorkid.R;
import com.example.colorkid.ViewHolder.ImageViewHolder;
import com.example.colorkid.WorkListActivity;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private Context context;
    private List<Integer> listimages;

    public ImageAdapter(Context context) {
        this.context = context;
        this.listimages = getImages();
    }

    private List<Integer> getImages() {
        List<Integer> results = new ArrayList<>();
        results.add(R.drawable.clip1);
        results.add(R.drawable.clip2);
        results.add(R.drawable.clip3);
        return results;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_images,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, final int position) {
    holder.imageView.setImageResource(listimages.get(position));
    holder.setImageOnClick(new ImageOnClick() {
        @Override
        public void onClick(int pos) {
            Common.ITEM_SELECTED = ""+(position+1);
            Common.PICTURE_SELECTED = listimages.get(pos);
            context.startActivity(new Intent(context, PaintActivity.class));
        }
    });
    holder.imageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Common.ITEM_SELECTED = ""+(1+position);
            context.startActivity(new Intent(context, WorkListActivity.class));
        }
    });
    }

    @Override
    public int getItemCount() {
        return listimages.size();
    }
}
