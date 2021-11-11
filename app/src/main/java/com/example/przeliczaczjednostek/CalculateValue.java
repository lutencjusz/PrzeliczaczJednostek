package com.example.przeliczaczjednostek;

public class CalculateValue {
    static final double YARD = 1.093613;
    private double meter;
    private double yard;

    public void CalculateMeter(double meterValue) {
        this.meter = meterValue;
        this.yard = meterValue * YARD;
    }

    public void CalculateYard(double yardValue) {
        this.yard = yardValue;
        this.meter = yardValue / YARD;
    }

    public double getMeter() {
        return meter;
    }

    public double getYard() {
        return yard;
    }
}
