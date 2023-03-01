package com.example.ecom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2>{
    String data4[];
    int image[];
    Context context;

    public MyAdapter2(Context ct, String[] s4, int[] img){
        context=ct;
        data4=s4;
        image=img;

    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.layout_listner, parent,false);
        MyViewHolder2 myViewHolder2= new MyViewHolder2(view);
        return (myViewHolder2);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder2 holder, int position) {
        String d= data4[position];
        int i= image[position];
         holder.txtOption.setText(d);
         holder.imgOption.setImageResource(i);
    }

    @Override
    public int getItemCount() {
        return data4.length;
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView txtOption;
        ImageView imgOption;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            imgOption=itemView.findViewById(R.id.imgOption);
            txtOption=itemView.findViewById(R.id.txtOption);
        }
    }
}
