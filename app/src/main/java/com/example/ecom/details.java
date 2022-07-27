package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ResourceBundle;

public class details extends Fragment {

    ImageView imageProduct;
    TextView txtProduct;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details, container, false);

        imageProduct= view.findViewById(R.id.imageProduct);
        txtProduct= view.findViewById(R.id.txtProduct);



        Bundle bundle= getArguments();
        String textpath1=bundle.getString("dt1");
        String textpath2= bundle.getString("dt2");
        Integer image= Integer.parseInt(textpath2);

        imageProduct.setImageResource(image);
        txtProduct.setText(textpath1);




        return view;
    }


}