package com.example.ecom;

import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class homeFragment extends Fragment implements Listner {

    Button cartBtn;
    RecyclerView recyclerView;
    String s1[], s2[], s3[];
    int images[]= {R.drawable.jean, R.drawable.jwellery, R.drawable.lipstick, R.drawable.shirt, R.drawable.shoe,R.drawable.tshirt,
        R.drawable.shot};
    View view;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= view.findViewById(R.id.recyclerView);
        cartBtn=view.findViewById(R.id.cartBtn);

        s1= getResources().getStringArray(R.array.products);
        s2= getResources().getStringArray(R.array.description);
        s3= getResources().getStringArray(R.array.price);

        cartBtn.setOnClickListener(view1 -> {

        });

        MyAdapter myAdapter= new MyAdapter(this.getContext(), s1, s2, s3, images, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));

        return view.getRootView();


    }


    @Override
    public void onClicked(DataClass data) {
        String str= data.name;
        int img= data.image;
        Bundle bundle= new Bundle();
        bundle.putString("dt1",str);
        bundle.putString("dt2", String.valueOf(img));

        Fragment fragment = new details();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}