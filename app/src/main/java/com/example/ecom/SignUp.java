package com.example.ecom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    TextInputEditText firstName, lastName, emailId, password;
    Button newSignup,newLogin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName= findViewById(R.id.txtFirstName);
        lastName= findViewById(R.id.txtLastName);
        emailId= findViewById(R.id.txtPhone);
        password= findViewById(R.id.textPassword);
        newSignup= findViewById(R.id.btnNewSignup);
        newLogin= findViewById(R.id.btnNewLogin);
        mAuth = FirebaseAuth.getInstance();


        newSignup.setOnClickListener(view ->{
            createUser();
        });
        newLogin.setOnClickListener(view -> {
            startActivity(new Intent(SignUp.this,MainActivity.class));
        });

    }


    private void createUser() {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String email = emailId.getText().toString();
        String pass = password.getText().toString();

        if(TextUtils.isEmpty(fName)){
            firstName.setError("First Name empty");
            firstName.requestFocus();
        }
        else if(TextUtils.isEmpty(lName)){
            lastName.setError("Last Name empty");
            lastName.requestFocus();
        }
        else if(TextUtils.isEmpty(email)){
            emailId.setError("EmailID empty");
            emailId.requestFocus();
        }
        else if(TextUtils.isEmpty(pass)){
            password.setError("Password empty");
            password.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        myMethod(new EmployeeInfo(fName, lName, email));
                        Toast.makeText(SignUp.this,"SUCESSFULL",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this,MainActivity.class));
                    }else{
                        Toast.makeText(SignUp.this,"UNSUCESSFULL",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text= adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    void myMethod(EmployeeInfo employee){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://ecom-e485e-default-rtdb.firebaseio.com");
        DatabaseReference myRef = database.getReference("user");

        myRef.child(Objects.requireNonNull(mAuth.getUid())).setValue(employee).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d("Sun", "onComplete: ");
                }
            }
        });
    }

}