package com.example.ecom;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    String data1[], data2[], data3[];
    int images[];
    Context context;
    Listner listner;

    public MyAdapter(Context ct, String[] s1, String[] s2, String[] s3, int[] img, Listner listner){
        context = ct;
        data1= s1;
        data2=s2;
        data3=s3;
        images= img;
        this.listner= listner;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row, parent,false);
        MyViewHolder myViewHolder1= new MyViewHolder(view);
        return (myViewHolder1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String d = data1[position];
        int i = images[position];
        String c= data2[position];

        holder.myText1.setText(d);
        holder.myText2.setText(data2[position]);

        holder.myText3.setText(data3[position]);
        try {
            holder.myImage.setImageResource(i);
        }catch (Exception e){
            Log.d("7",e.toString());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onClicked(new DataClass(i, d, c));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1,myText2,myText3;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1= itemView.findViewById(R.id.myText1);
            myText2= itemView.findViewById(R.id.myText2);
            myText3= itemView.findViewById(R.id.myText3);
            myImage= itemView.findViewById(R.id.myImageView);

        }
    }



}
