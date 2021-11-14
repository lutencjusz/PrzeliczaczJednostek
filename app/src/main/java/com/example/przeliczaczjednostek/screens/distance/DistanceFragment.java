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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.przeliczaczjednostek.App;
import com.example.przeliczaczjednostek.CalculateValue;
import com.example.przeliczaczjednostek.PlActionEvent;
import com.example.przeliczaczjednostek.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.text.DecimalFormat;
import java.util.Locale;

public class DistanceFragment extends Fragment {

    private EditText etValue;
    private Button btnMeter;
    private Button btnYard;
    private Button btnFoot;
    private Button btnInch;
    private Button btnMileM;
    private Button btnMileL;
    private CalculateValue calculateValue;
    private DecimalFormat df;
    private Resources resources;
    private Configuration configuration;
    private SharedPreferences sharedPreferences;
    private Bus bus;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    private void saveCurrentLanguageInSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.SharedPreferencesValue), configuration.getLocales().get(0).getLanguage());
        editor.apply();
    }

//    private void updateContentViewAndLang(Locale locale) {
//        configuration.setLocale(locale);
//        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//        setContentView(R.layout.activity_distance);
//        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
//        saveCurrentLanguage();
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
//            this.finishAffinity();
            return true;
        } else if (id == R.id.eng_flag) {
//            updateContentViewAndLang(new Locale("en"));
            return true;
        } else if (id == R.id.pl_flag) {
//            updateContentViewAndLang(new Locale("pl"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void bindAll() {
        btnMeter = btnMeter.findViewById(R.id.btnMeter);
        btnYard = btnYard.findViewById(R.id.btnYard);
        btnFoot = btnFoot.findViewById(R.id.btnFoot);
        btnInch = btnInch.findViewById(R.id.btnInch);
        btnMileL = btnMileL.findViewById(R.id.btnMileL);
        btnMileM = btnMileM.findViewById(R.id.btnMileM);
        etValue = etValue.findViewById(R.id.edNumber);
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
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);
        return view;
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

    //    @SuppressLint("ClickableViewAccessibility")
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        resources = this.getResources();
//        configuration = resources.getConfiguration();
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
////        updateContentViewAndLang(sharedPreferences.getString(getString(R.string.SharedPreferencesValue), "").equals("")
////                ? configuration.getLocales().get(0)
////                : new Locale(sharedPreferences.getString(getString(R.string.SharedPreferencesValue), "")));
//        bindAll();
//        calculateValue = new CalculateValue();
//        df = new DecimalFormat();
//        df.setMaximumFractionDigits(4);
//        df.setMinimumFractionDigits(0);
//    }

    @Subscribe
    public void onPlActionEvent(PlActionEvent event) {
        configuration.setLocale(new Locale("pl"));
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        saveCurrentLanguageInSharedPreferences();
    }

    public void onClick(View view) {

        bindAll();
        if (etValue.getText().length() == 0) {
            etValue.setText(R.string.default_value);
        }
        double value = Double.parseDouble(etValue.getText().toString());
        if (view.getId() == R.id.btnMeter) {
            calculateValue.calculateMeter(value);
        } else if (view.getId() == R.id.btnYard) {
            calculateValue.calculateYard(value);
        } else if (view.getId() == R.id.btnFoot) {
            calculateValue.calculateFoot(value);
        } else if (view.getId() == R.id.btnInch) {
            calculateValue.calculateInch(value);
        } else if (view.getId() == R.id.btnMileL) {
            calculateValue.calculateMileL(value);
        } else if (view.getId() == R.id.btnMileM) {
            calculateValue.calculateMileM(value);
        }

        btnMeter.setText(String.format(getString(R.string.formatMeter), df.format(calculateValue.getMeter())));
        btnYard.setText(String.format(getString(R.string.formatYards), df.format(calculateValue.getYard())));
        btnFoot.setText(String.format(getString(R.string.formatFeet), df.format(calculateValue.getFeet())));
        btnInch.setText(String.format(getString(R.string.formatInch), df.format(calculateValue.getInch())));
        btnMileL.setText(String.format(getString(R.string.formatMileL), df.format(calculateValue.getMileL())));
        btnMileM.setText(String.format(getString(R.string.formatMileM), df.format(calculateValue.getMileM())));
    }

}