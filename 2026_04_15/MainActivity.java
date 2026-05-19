package com.example.a2026_04_15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int clickCount = 0;
    private EditText etName;
    private EditText etEmail;
    private Button btnIncrease;
    private TextView txt1;
    private TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnIncrease = findViewById(R.id.btnIncrease);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt("KEY_CLICK_COUNT", 0);
            String savedTxt1 = savedInstanceState.getString("KEY_TXT1_TEXT", "");
            txt1.setText(savedTxt1);
            updateCounterText();
        }
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
                } else {
                    clickCount++;
                    updateCounterText();
                    txt1.setText("Witaj, " + name + "! Twój adres e-mail to: " + email);
                }
            }
        });
    }
    private void updateCounterText() {
        txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY_CLICK_COUNT", clickCount);
        outState.putString("KEY_TXT1_TEXT", txt1.getText().toString());
    }
}