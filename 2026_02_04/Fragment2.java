package com.example.a2026_02_04;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private static final String ARG_EMAIL = "email";
    private static final String ARG_IMIE = "imie";
    private static final String ARG_NAZWISKO = "nazwisko";

    private String email;
    private String imie;
    private String nazwisko;

    public Fragment2() {
    }

    public static Fragment2 newInstance(String email, String imie, String nazwisko) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_IMIE, imie);
        args.putString(ARG_NAZWISKO, nazwisko);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);


        if (getArguments() != null) {
            email = getArguments().getString(ARG_EMAIL);
            imie = getArguments().getString(ARG_IMIE);
            nazwisko = getArguments().getString(ARG_NAZWISKO);
        }
        TextView labelEmail = view.findViewById(R.id.labelEmail);
        TextView labelImie = view.findViewById(R.id.labelImie);
        TextView labelNazwisko = view.findViewById(R.id.labelNazwisko);

        labelEmail.setText("Email: " + email);
        labelImie.setText("Imię: " + imie);
        labelNazwisko.setText("Nazwisko: " + nazwisko);

        return view;
    }
}
