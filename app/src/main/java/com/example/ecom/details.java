package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ResourceBundle;

public class details extends Fragment {

    ImageView imageProduct;
    TextView txtProduct,txtDescription;
    Button btnShare;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details, container, false);

        imageProduct= view.findViewById(R.id.imageProduct);
        txtProduct= view.findViewById(R.id.txtProduct);
        txtDescription= view.findViewById(R.id.txtDescription);
        btnShare= view.findViewById(R.id.btnShare);



        Bundle bundle= getArguments();
        String textpath1=bundle.getString("dt1");
        String textpath2= bundle.getString("dt2");
        String textpath3= bundle.getString("dt3");
        Integer image= Integer.parseInt(textpath2);



        imageProduct.setImageResource(image);
        txtProduct.setText(textpath1);
        txtDescription.setText(textpath3);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plan");
                String shareBody= textpath1 + " "+ textpath3 +" (Buy your product from Ecom store now)";
                String shareSub = "Your subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent, "Share it"));
            }
        });




        return view;
    }


}