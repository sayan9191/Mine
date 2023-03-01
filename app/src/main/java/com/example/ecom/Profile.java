package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile extends Fragment {

    Button btnLogout;
    FirebaseAuth mAuth;
    TextView txtFnameDisplay,txtLnameDisplay,txtEmailDisplay;
    TextView txtViewVersioncode, txtViewVersionName;



    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        mAuth= FirebaseAuth.getInstance();
        btnLogout= view.findViewById(R.id.btnLogout);


        txtFnameDisplay=view.findViewById(R.id.txtFnameDisplay);
        txtLnameDisplay=view.findViewById(R.id.txtLnameDisplay);
        txtEmailDisplay= view.findViewById(R.id.txtEmailDisplay);


        //version display
        txtViewVersioncode= view.findViewById(R.id.txtViewVersioncode);
        txtViewVersioncode.setText(String.valueOf(BuildConfig.VERSION_CODE));


        txtViewVersionName= view.findViewById(R.id.txtVersionName);
        txtViewVersionName.setText(String.valueOf(BuildConfig.VERSION_NAME));


        btnLogout.setOnClickListener(view1 -> {
            mAuth.signOut();
            Intent intent= new Intent(getActivity().getApplication(),MainActivity.class);
            startActivity(intent );
        });

        getUser();

        return  view;



    }
    private void getUser(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://ecom-e485e-default-rtdb.firebaseio.com");
        DatabaseReference myRef = database.getReference("user");

        myRef.child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    EmployeeInfo info = dataSnapshot.getValue(EmployeeInfo.class);
                    if(info!=null)
                        txtFnameDisplay.setText(info.getFirstName());
                        txtLnameDisplay.setText(info.getLastName());
                        txtEmailDisplay.setText(info.getEmailId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}