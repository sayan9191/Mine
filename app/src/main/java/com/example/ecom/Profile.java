package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class Profile extends Fragment {

    Button btnLogout;
    FirebaseAuth mAuth;



    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        mAuth= FirebaseAuth.getInstance();
        btnLogout= view.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view1 -> {
            mAuth.signOut();
            Intent intent= new Intent(getActivity().getApplication(),MainActivity.class);
            startActivity(intent );
        });

        return  view;



    }
}