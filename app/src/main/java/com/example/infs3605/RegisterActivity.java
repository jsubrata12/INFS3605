package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    Button registerBtn2;
    EditText username, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize the buttons and editText fields.
        username = findViewById(R.id.registerUsername);
        password = findViewById(R.id.registerPassword);
        registerBtn2 = findViewById(R.id.signUp);

        // Initialize Firebase Authentication in order to later store the user data in the Firebase Console
        mAuth = FirebaseAuth.getInstance();

        // Create a listener once the user presses register and check if it fulfils the conditions
        registerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve information from the edit text fields to be tested for conditions
                String email = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                // Notify the user if the field is empty
                if (email.isEmpty()) {
                    username.setError("Email is empty");
                    username.requestFocus();
                    return;
                }
                // Notify the user if the email is valid
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    username.setError("Please enter a valid email address");
                    username.requestFocus();
                    return;
                }
                // Notify the user if the password field is empty
                if (pass.isEmpty()) {
                    password.setError("Please enter a password");
                    password.requestFocus();
                    return;
                }
                // Notify the user if the password length is less than 6 characters
                if (pass.length() < 6) {
                    password.setError("Password must be 6 chars or longer");
                    password.requestFocus();
                    return;
                }
                // Create a listener to determine if all conditions are met
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If conditions are met the data will be transferred to the Firebase Console and the user is returned to the login activity.
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "You Have Successfully Registered!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        // If the conditions are not fulfilled, notify the user.
                        else {
                            Toast.makeText(RegisterActivity.this, "Registration Failed. Please Try Again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}
