package com.example.przeliczaczjednostek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void updateContentView(Locale locale) {
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            this.finishAffinity();
            return true;
        } else if (id == R.id.eng_flag) {
            updateContentView(new Locale("en"));
            return true;
        } else if (id == R.id.pl_flag) {
            updateContentView(new Locale("pl"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void bindAll(){
        btnMeter = findViewById(R.id.btnMeter);
        btnYard = findViewById(R.id.btnYard);
        btnFoot = findViewById(R.id.btnFoot);
        btnInch = findViewById(R.id.btnInch);
        btnMileL = findViewById(R.id.btnMileL);
        btnMileM = findViewById(R.id.btnMileM);
        etValue = findViewById(R.id.edNumber);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resources = this.getResources();
        configuration = resources.getConfiguration();
        updateContentView(configuration.getLocales().get(0));
        bindAll();
        calculateValue = new CalculateValue();
        df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        df.setMinimumFractionDigits(0);
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