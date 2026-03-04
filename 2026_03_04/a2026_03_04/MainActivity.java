package com.example.a2026_03_04;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Klucze do Intentu
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_SURNAME = "extra_surname";
    public static final String EXTRA_CLASS = "extra_class";

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etClass;
    private Button btnReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName  = findViewById(R.id.etLastName);
        etClass     = findViewById(R.id.etClass);
        btnReport   = findViewById(R.id.btnReport);

        btnReport.setOnClickListener(v -> onReportClicked());
    }

    private void onReportClicked() {
        String name    = etFirstName.getText() != null ? etFirstName.getText().toString().trim() : "";
        String surname = etLastName.getText()  != null ? etLastName.getText().toString().trim()  : "";
        String clazz   = etClass.getText()     != null ? etClass.getText().toString().trim()     : "";

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(clazz)) {
            Toast.makeText(this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, ReportedActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_SURNAME, surname);
        intent.putExtra(EXTRA_CLASS, clazz);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Dodaję uwagę…");
        progressDialog.setMessage("Proszę czekać.");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

        etFirstName.setText("");
        etLastName.setText("");
        etClass.setText("");

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (progressDialog.isShowing()) progressDialog.dismiss();
            startActivity(intent);
        }, 2000);
    }
}