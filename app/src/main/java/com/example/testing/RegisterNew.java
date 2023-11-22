package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterNew extends AppCompatActivity {
    EditText editTextId, editTextPassword;
    Button buttonRegister;

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new);
        editTextId = findViewById(R.id.idregister);
        editTextPassword = findViewById(R.id.passwordregister);
        buttonRegister = findViewById(R.id.registermeBtn);

        mFirebaseAuth = FirebaseAuth.getInstance();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextId.getText().toString())) {
                    Toast.makeText(RegisterNew.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
                    Toast.makeText(RegisterNew.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else if (editTextPassword.getText().toString().length() < 6) {
                    Toast.makeText(RegisterNew.this, "Password too short", Toast.LENGTH_SHORT).show();
                }else{
                    mFirebaseAuth.createUserWithEmailAndPassword(editTextId.getText().toString(), editTextPassword.getText().toString()).addOnCompleteListener(RegisterNew.this, task -> {
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterNew.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterNew.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}