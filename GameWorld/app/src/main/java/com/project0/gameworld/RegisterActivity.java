package com.project0.gameworld;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    TextView alreadyHaveanAccount;
    EditText inputEmail,inputPassword,inputConfPassword;
    Button btnRegister;
    String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        alreadyHaveanAccount= findViewById(R.id.mTvExist);

        inputEmail=findViewById(R.id.mEdtEmail);
        inputPassword=findViewById(R.id.mEdtPass);
        inputConfPassword=findViewById(R.id.mEdtConfPass);
        btnRegister=findViewById(R.id.mBtnLogin);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        alreadyHaveanAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
    }

    private void PerforAuth() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirm_password=inputConfPassword.getText().toString();
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (!email.matches(emailPattern)){
            inputEmail.setError("Enter Correct Email");
        }else if (password.isEmpty() || password.length()<6)
        {
            inputPassword.setError("Enter Proper Password");
        }else if (!password.equals(confirm_password))
        {
            inputConfPassword.setError("Passwords Don't Match");
        }else{
            progressDialog.setMessage("Please Wait For Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        sendUserToNextActivity();
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"Registration Successful!", Toast.LENGTH_LONG).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, ""+task.getException(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent home=new Intent(RegisterActivity.this, MainActivity.class);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(home);
    }
}