package com.example.przeliczaczjednostek.screens.distance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.przeliczaczjednostek.App;
import com.example.przeliczaczjednostek.CalculateValue;
import com.example.przeliczaczjednostek.events.EnActionEvent;
import com.example.przeliczaczjednostek.events.PlActionEvent;
import com.example.przeliczaczjednostek.R;
import com.example.przeliczaczjednostek.events.DistanceFragmentActionEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.text.DecimalFormat;

public class DistanceFragment extends Fragment {

    private EditText etValue;
    private Button btnMeter;
    private Button btnYard;
    private Button btnFeet;
    private Button btnInch;
    private Button btnMileM;
    private Button btnMileL;
    private CalculateValue calculateValue;
    private DecimalFormat df;
    private Resources resources;
    private Configuration configuration;
    private SharedPreferences sharedPreferences;
    private Bus bus;
    private View view;

    private void saveCurrentLanguageInSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.SharedPreferencesValue), configuration.getLocales().get(0).getLanguage());
        editor.apply();
    }

    private void bindAll(View view) {
        btnMeter = view.findViewById(R.id.btnMeter);
        btnYard = view.findViewById(R.id.btnYard);
        btnFeet = view.findViewById(R.id.btnFoot);
        btnInch = view.findViewById(R.id.btnInch);
        btnMileL = view.findViewById(R.id.btnMileL);
        btnMileM = view.findViewById(R.id.btnMileM);
        etValue = view.findViewById(R.id.edNumber);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculateValue = new CalculateValue();
        df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        df.setMinimumFractionDigits(0);
        bus = ((App) getActivity().getApplication()).getBus();
        resources = this.getResources();
        configuration = resources.getConfiguration();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
//        updateContentViewAndLang(sharedPreferences.getString(getString(R.string.SharedPreferencesValue), "").equals("")
//                ? configuration.getLocales().get(0)
//              : new Locale(sharedPreferences.getString(getString(R.string.SharedPreferencesValue), "")));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_distance, container, false);
        bindAll(view);
        bindButtonToListener(view, btnMeter, "meter");
        bindButtonToListener(view, btnYard, "yard");
        bindButtonToListener(view, btnFeet, "feet");
        bindButtonToListener(view, btnInch, "inch");
        bindButtonToListener(view, btnMileL, "mileL");
        bindButtonToListener(view, btnMileM, "mileM");
        return view;
    }

    private void bindButtonToListener(View view, Button button, String unit) {
        button = view.findViewById(button.getId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etValue.getText().length() == 0) {
                    etValue.setText(R.string.default_value);
                }
                double value = Double.parseDouble(etValue.getText().toString());
                calculateValue.calculate(value, unit);
                btnMeter.setText(String.format(getString(R.string.formatMeter), df.format(calculateValue.getMeter())));
                btnYard.setText(String.format(getString(R.string.formatYards), df.format(calculateValue.getYard())));
                btnFeet.setText(String.format(getString(R.string.formatFeet), df.format(calculateValue.getFeet())));
                btnInch.setText(String.format(getString(R.string.formatInch), df.format(calculateValue.getInch())));
                btnMileL.setText(String.format(getString(R.string.formatMileL), df.format(calculateValue.getMileL())));
                btnMileM.setText(String.format(getString(R.string.formatMileM), df.format(calculateValue.getMileM())));
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    @Subscribe
    public void onPlActionEvent(PlActionEvent event) {
        saveCurrentLanguageInSharedPreferences();
        bus.post(new DistanceFragmentActionEvent());
    }

    @Subscribe
    public void onEnActionEvent(EnActionEvent event) {
        saveCurrentLanguageInSharedPreferences();
        bus.post(new DistanceFragmentActionEvent());
    }
}