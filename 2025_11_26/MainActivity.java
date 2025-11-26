package com.example.a2025_11_26;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText4;
    private TextView textView3;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText4 = findViewById(R.id.editText4);
        textView3 = findViewById(R.id.textView3);
        button5 = findViewById(R.id.button5);


        button5.setOnClickListener(v -> {
            String text = editText4.getText().toString();
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void copyText(View view) {
        String text = editText1.getText().toString();
        textView3.setText(text);
    }
}
