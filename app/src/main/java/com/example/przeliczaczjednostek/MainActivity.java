package com.example.przeliczaczjednostek;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMeter = findViewById(R.id.btnMeter);
        btnYard = findViewById(R.id.btnYard);
        btnFoot = findViewById(R.id.btnFoot);
        btnInch = findViewById(R.id.btnInch);
        btnMileL = findViewById(R.id.btnMileL);
        btnMileM = findViewById(R.id.btnMileM);

        etValue = findViewById(R.id.edNumber);
        calculateValue = new CalculateValue();
        df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        df.setMinimumFractionDigits(0);
    }

    public void onClick(View view) {
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