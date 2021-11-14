package com.example.przeliczaczjednostek;

public class CalculateValue {
    static final double YARD = 1.093613;
    static final double FEET = 3.280839895;
    static final double INCH = 39.370;
    static final double MILEM = 0.00054;
    static final double MILEL = 0.0006215;

    private double meter;
    private double yard;
    private double feet;
    private double inch;
    private double mileL;
    private double mileM;

    public void calculateMeter(double meterValue) {
        this.meter = meterValue;
        this.yard = meterValue * YARD;
        this.feet = meterValue * FEET;
        this.inch = meterValue * INCH;
        this.mileM = meterValue * MILEM;
        this.mileL = meterValue * MILEL;
    }

    public void calculateYard(double yardValue) {
        this.yard = yardValue;
        this.meter = yardValue / YARD;
        this.feet = this.meter * FEET;
        this.inch = this.meter * INCH;
        this.mileM = this.meter * MILEM;
        this.mileL = this.meter * MILEL;
    }

    public void calculateFeet(double feetValue) {
        this.feet = feetValue;
        this.meter = feetValue / FEET;
        this.yard = this.meter * YARD;
        this.inch = this.meter * INCH;
        this.mileM = this.meter * MILEM;
        this.mileL = this.meter * MILEL;
    }

    public void calculateInch(double inchValue) {
        this.inch = inchValue;
        this.meter = inchValue / INCH;
        this.yard = this.meter * YARD;
        this.feet = this.meter * FEET;
        this.mileM = this.meter * MILEM;
        this.mileL = this.meter * MILEL;
    }

    public void calculateMileL(double mileLvalue) {
        this.mileL = mileLvalue;
        this.meter = mileLvalue / MILEL;
        this.yard = this.meter * YARD;
        this.feet = this.meter * FEET;
        this.mileM = this.meter * MILEM;
        this.inch = this.meter * INCH;
    }

    public void calculateMileM(double mileMvalue) {
        this.mileM = mileMvalue;
        this.meter = mileMvalue / MILEM;
        this.yard = this.meter * YARD;
        this.feet = this.meter * FEET;
        this.inch = this.meter * INCH;
        this.mileL = this.meter * MILEL;
    }

    public double getMeter() {
        return meter;
    }

    public double getYard() {
        return yard;
    }

    public double getFeet() {
        return feet;
    }

    public double getInch() {
        return inch;
    }

    public double getMileL() {
        return mileL;
    }

    public double getMileM() {
        return mileM;
    }

    public void calculate(double value, String unit) {
        if (unit.equals("meter")) {
            calculateMeter(value);
        } else if (unit.equals("yard")) {
            calculateYard(value);
        } else if (unit.equals("feet")) {
            calculateFeet(value);
        } else if (unit.equals("inch")) {
            calculateInch(value);
        } else if (unit.equals("mileL")) {
            calculateMileL(value);
        } else if (unit.equals("mileM")) {
            calculateMileM(value);
        }
    }
}
