package com.example.a2025_12_03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView tvLoggedAs = findViewById(R.id.tvLoggedAs);
        Button btnLogout = findViewById(R.id.btnLogout);

        String email = getIntent().getStringExtra("USER_EMAIL");
        tvLoggedAs.setText("Zalogowano jako: " + email);

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}