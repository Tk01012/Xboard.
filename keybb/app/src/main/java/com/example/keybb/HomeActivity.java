package com.example.keybb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.keybb.keyboard.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Button setti;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });

        setti = findViewById(R.id.KeyboardSet);
        setti.setOnClickListener(v -> {
            Intent intToSet = new Intent(HomeActivity.this,SetActivity.class);
            startActivity(intToSet);

        });


        /*
        manageKeyboard = findViewById(R.id.ManageKeyboard);
        manageKeyboard.setOnClickListener(v -> {
            startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));

        });

        selectKeyboard= findViewById(R.id.SelectKeyboard);
        selectKeyboard.setOnClickListener(v -> {
            InputMethodManager imeManager = (InputMethodManager)
                    getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
            imeManager.showInputMethodPicker();
        });

         */

    }
}