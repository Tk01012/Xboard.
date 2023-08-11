package com.example.keybb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.keybb.keyboard.R;

public class SetActivity extends AppCompatActivity {
    private Button manageKeyboard;
    private Button selectKeyboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

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
    }
}