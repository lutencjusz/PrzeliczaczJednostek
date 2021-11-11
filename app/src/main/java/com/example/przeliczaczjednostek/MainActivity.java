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
    private CalculateValue calculateValue;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMeter = findViewById(R.id.btnMeter);
        btnYard = findViewById(R.id.btnYard);
        etValue = findViewById(R.id.edNumber);
        calculateValue = new CalculateValue();
        df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        df.setMinimumFractionDigits(0);
    }

    public void onClick(View view) {
        double value = Double.parseDouble(etValue.getText().toString());
        if (view.getId() == R.id.btnMeter) {
            calculateValue.CalculateMeter(value);
        } else if (view.getId() == R.id.btnYard) {
            calculateValue.CalculateYard(value);
        }
        btnMeter.setText(String.format(getString(R.string.formatMeter), df.format(calculateValue.getMeter())));
        btnYard.setText(String.format(getString(R.string.formatYards), df.format(calculateValue.getYard())));
    }

}