package com.example.przeliczaczjednostek.screens.scale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.przeliczaczjednostek.CalculateValue;
import com.example.przeliczaczjednostek.R;
import com.squareup.otto.Bus;
import java.text.DecimalFormat;

public class ScaleFragment extends Fragment {

    private EditText etValue;
    private Button btnKGram;
    private Button btnKarat;
    private Button btnFunt;
    private Button btnUncja;
    private Button btnLut;
    private Button btnCentarM;
    private Button btnCentarD;
    private CalculateValue calculateValue;
    private DecimalFormat df;

    private void bindAll(View view) {
        btnKGram = view.findViewById(R.id.btnKGram);
        btnKarat = view.findViewById(R.id.btnKarat);
        btnFunt = view.findViewById(R.id.btnFunt);
        btnUncja = view.findViewById(R.id.btnUncja);
        btnLut = view.findViewById(R.id.btnLut);
        btnCentarM = view.findViewById(R.id.btnCentarM);
        btnCentarD = view.findViewById(R.id.btnCentarD);
        etValue = view.findViewById(R.id.edScaleNumber);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculateValue = new CalculateValue();
        df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        df.setMinimumFractionDigits(0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scale, container, false);
        bindAll(view);
        bindButtonToListener(view, btnKGram, "kgram");
        bindButtonToListener(view, btnKarat, "karat");
        bindButtonToListener(view, btnFunt, "funt");
        bindButtonToListener(view, btnUncja, "uncja");
        bindButtonToListener(view, btnLut, "lut");
        bindButtonToListener(view, btnCentarM, "centarM");
        bindButtonToListener(view, btnCentarD, "centarD");
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
                btnKGram.setText(String.format(getString(R.string.formatKGram), df.format(calculateValue.getKgram())));
                btnKarat.setText(String.format(getString(R.string.formatKarat), df.format(calculateValue.getKarat())));
                btnFunt.setText(String.format(getString(R.string.formatFunt), df.format(calculateValue.getFunt())));
                btnUncja.setText(String.format(getString(R.string.formatUncja), df.format(calculateValue.getUncja())));
                btnLut.setText(String.format(getString(R.string.formatLut), df.format(calculateValue.getLut())));
                btnCentarM.setText(String.format(getString(R.string.formatCetnarM), df.format(calculateValue.getCetnarM())));
                btnCentarD.setText(String.format(getString(R.string.formatCetnarD), df.format(calculateValue.getCetnarD())));
            }
        });
    }
}