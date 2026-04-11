package com.example.a2026_03_18;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etOwnerName, etPurpose, etTime;
    private ListView lvSpecies;
    private SeekBar sbAge;
    private TextView tvAgeValue, tvSummary;
    private Button btnOk;
    private String selectedSpecies = "Pies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOwnerName = findViewById(R.id.etOwnerName);
        etPurpose = findViewById(R.id.etPurpose);
        etTime = findViewById(R.id.etTime);
        lvSpecies = findViewById(R.id.lvSpecies);
        sbAge = findViewById(R.id.sbAge);
        tvAgeValue = findViewById(R.id.tvAgeValue);
        tvSummary = findViewById(R.id.tvSummary);
        btnOk = findViewById(R.id.btnOk);

        lvSpecies.setOnItemClickListener((parent, view, position, id) -> {
            selectedSpecies = (String) parent.getItemAtPosition(position);

            switch (selectedSpecies) {
                case "Pies": sbAge.setMax(18); break;
                case "Kot": sbAge.setMax(20); break;
                case "Świnka morska": sbAge.setMax(9); break;
            }
            if (sbAge.getProgress() > sbAge.getMax()) {
                sbAge.setProgress(sbAge.getMax());
                tvAgeValue.setText(String.valueOf(sbAge.getMax()));
            }
        });
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAgeValue.setText(String.valueOf(progress));
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        btnOk.setOnClickListener(v -> {
            String owner = etOwnerName.getText().toString();
            int age = sbAge.getProgress();
            String purpose = etPurpose.getText().toString();
            String time = etTime.getText().toString();

            String result = owner + ", " + selectedSpecies + ", " + age + ", " + purpose + ", " + time;
            tvSummary.setText(result);

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        });
    }
}