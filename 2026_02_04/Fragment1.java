package com.example.a2026_02_04;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    private EditText emailInput, imieInput, nazwiskoInput;
    private Button buttonNext;

    public Fragment1() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        emailInput = view.findViewById(R.id.inputEmail);
        imieInput = view.findViewById(R.id.inputImie);
        nazwiskoInput = view.findViewById(R.id.inputNazwisko);
        buttonNext = view.findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(v -> {

            String email = emailInput.getText().toString();
            String imie = imieInput.getText().toString();
            String nazwisko = nazwiskoInput.getText().toString();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(imie) || TextUtils.isEmpty(nazwisko)) {
                Toast.makeText(getActivity(), "Wszystkie pola muszą być uzupełnione!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(getActivity(), "Niepoprawny adres e-mail!", Toast.LENGTH_SHORT).show();
                return;
            }
            Fragment2 fragment2 = Fragment2.newInstance(email, imie, nazwisko);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}

