package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    TextView username, password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        LoadingDialog loadingDialog = new LoadingDialog(LoginActivity.this);


        // Initialize the text view and buttons from the xml file
        username = findViewById(R.id.registerUsername);
        password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginbtn);
        Button registerBtn = findViewById(R.id.registerbtn);
        // Initialize Firebase Authentication in order to connect to the Firebase Console (for storing user data)
        mAuth = FirebaseAuth.getInstance();

        // Create a listener for the login button to detect if the user is registered in the system
        loginBtn.setOnClickListener(view -> {
            // Assign a variable to the text from the email and password fields for testing conditions
            String email = username.getText().toString().trim();
            String pass = password.getText().toString().trim();
            // Notify user if username is empty
            if (email.isEmpty()) {
                username.setError("Username is empty");
                username.requestFocus();
                return;
            }
            // Notify user if the email is invalid
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                username.setError("Please enter the valid email address");
                username.requestFocus();
                return;
            }
            //  Notify user if the password is empty
            if (pass.isEmpty()) {
                password.setError("Please enter a password");
                password.requestFocus();
                return;
            }
            //  Notify user if the password is less than 6 characters.
            if (pass.length() < 6) {
                password.setError("Password must be 6 chars or longer");
                password.requestFocus();
                return;
            }
            // Add a listener to check the validity of the login details
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                // Move onto the Homepage activity if the login credentials exist in the system
                if (task.isSuccessful()) {
                    loadingDialog.startLoadingAnimation();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingDialog.dismissDialog();
                        }
                    }, 1000);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                // Notify user if the credentials are wrong/unmatched.
                } else {
                    Toast.makeText(LoginActivity.this, "Please Check Your Login Credentials", Toast.LENGTH_SHORT).show();
                }
            });
        });
        // Add a listener to the register button to allow the user to create an account
        registerBtn.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }
}
