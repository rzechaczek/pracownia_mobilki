package com.example.a2025_12_03;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword, etPasswordRepeat;
    Button btnSubmit;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordRepeat = findViewById(R.id.etPasswordRepeat);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvMessage = findViewById(R.id.tvMessage);

        btnSubmit.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String pass = etPassword.getText().toString();
            String pass2 = etPasswordRepeat.getText().toString();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                showError("Nieprawidłowy adres e-mail");
                return;
            }
            Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
            if (!passwordPattern.matcher(pass).matches()) {
                showError("Hasło musi mieć 8 znaków, wielką i małą literę oraz cyfrę");
                return;
            }
            if (!pass.equals(pass2)) {
                showError("Hasła się różnią");
                return;
            }
            tvMessage.setTextColor(Color.GRAY);
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            intent.putExtra("USER_EMAIL", email);
            startActivity(intent);
        });
    }

    private void showError(String message) {
        tvMessage.setTextColor(Color.RED);
        tvMessage.setText(message);
    }
}