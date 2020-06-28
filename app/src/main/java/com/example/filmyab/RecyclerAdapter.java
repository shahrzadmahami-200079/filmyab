package com.example.filmyab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<ModelItem> requestItems;
    Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {

        mListener = listener;
    }


    public RecyclerAdapter(Context context, List<ModelItem> requestItems) {
        this.context = context;
        this.requestItems = requestItems;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemTextView);
            imageView = itemView.findViewById(R.id.imageview);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_popular,
                parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(requestItems.get(position).getNameMovie());
        Glide.with(context).load(requestItems.get(position).getPicture()).into(holder.imageView);
    }





    @Override
    public int getItemCount() {
        return requestItems.size();
    }
}