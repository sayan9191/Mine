package com.example.ecom;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class homeFragment extends Fragment implements Listner {


    Button cartBtn;
    RecyclerView recyclerView1;
    RecyclerView recyclerView;
    String s1[], s2[], s3[], s4[];
    int images[]= {R.drawable.jean, R.drawable.jwellery, R.drawable.lipstick, R.drawable.shirt, R.drawable.shoe,R.drawable.tshirt,
        R.drawable.shot,R.drawable.banana};
    int image[]={R.drawable.deal, R.drawable.mobile, R.drawable.electronics, R.drawable.fashion,R.drawable.furniture,
    R.drawable.grocery,R.drawable.medicine};
    View view;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= view.findViewById(R.id.recyclerView);
        recyclerView1= view.findViewById(R.id.recyclerView1);
        cartBtn= view.findViewById(R.id.cartBtn);

        s1= getResources().getStringArray(R.array.products);
        s2= getResources().getStringArray(R.array.description);
        s3= getResources().getStringArray(R.array.price);
        s4=getResources().getStringArray(R.array.topShow);


        // for products menu
        MyAdapter myAdapter= new MyAdapter(this.getContext(), s1, s2, s3, images, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));

        //for title menu
        MyAdapter2 myAdapter2=new MyAdapter2(this.getContext(),s4,image);
        LinearLayoutManager HorizontalLayout;
        HorizontalLayout= new LinearLayoutManager(homeFragment.this.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView1.setLayoutManager(HorizontalLayout);
        recyclerView1.setAdapter(myAdapter2);
        return view.getRootView();


    }


    @Override
    public void onClicked(DataClass data) {

        String str1= data.name;
        String  str2= data.details;
        int img= data.image;
        // testing for multile images


        Bundle bundle= new Bundle();
        bundle.putString("dt1",str1);
        bundle.putString("dt2", String.valueOf(img));
        bundle.putString("dt3",str2);


        Fragment fragment = new details();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

}