package com.example.a2026_03_04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReportedActivity extends AppCompatActivity {

    private TextView tvReportedName;
    private TextView tvReportedSurname;
    private TextView tvRepostedClass;
    private Button btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reported);

        tvReportedName    = findViewById(R.id.reported_name);
        tvReportedSurname = findViewById(R.id.reported_surname);
        tvRepostedClass   = findViewById(R.id.reported_class);
        btnAddNew         = findViewById(R.id.btnAddNew);


        String name    = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        String surname = getIntent().getStringExtra(MainActivity.EXTRA_SURNAME);
        String clazz   = getIntent().getStringExtra(MainActivity.EXTRA_CLASS);

        tvReportedName.setText(name != null ? name : "");
        tvReportedSurname.setText(surname != null ? surname : "");
        tvRepostedClass.setText(clazz != null ? clazz : "");


        btnAddNew.setOnClickListener(v -> finish());
    }
}