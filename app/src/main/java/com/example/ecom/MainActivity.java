package com.example.ecom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    Button login,signup;
    TextInputEditText username, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login= findViewById(R.id.btnLogIn);
        signup= findViewById(R.id.btnSingUp);
        username= findViewById(R.id.txtUsername);
        password= findViewById(R.id.txtPassword);
        mAuth= FirebaseAuth.getInstance();

        login.setOnClickListener(view -> {
            loginUser();
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Signup now",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user= mAuth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(MainActivity.this, Home.class));
        }
    }

    

    private void loginUser() {
        String Email= username.getText().toString();
        String pass= password.getText().toString();

        if(TextUtils.isEmpty(Email)){
            username.setError("Email id empty");
            username.requestFocus();
        }
        else if(TextUtils.isEmpty(pass)){
            password.setError("password is empty");
            password.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(Email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(MainActivity.this, Home.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Wrong Email id or password",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "App closed", Toast.LENGTH_SHORT).show();
    }

}
