package com.example.ecom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    String productName[],productPrice[];
    int productImages[];
    Context context;

    public CartAdapter(Context ct, String[] s1, String[] s3, int img[]){
        context= ct;
        productImages= img;
        productName=s1;
        productPrice=s3;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.cart_feed,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
//        doubt
        return (viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name= productName[position];
        String price= productPrice[position];
        int pImage= productImages[position];
        holder.favTextview.setText(name);
        holder.favPrice.setText(price);
        holder.favImageview.setImageResource(pImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView favImageview;
        TextView favTextview,favPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favImageview= itemView.findViewById(R.id.favImageview);
            favTextview= itemView.findViewById(R.id.favTextview);
            favPrice= itemView.findViewById(R.id.favPrice);
        }
    }
}
