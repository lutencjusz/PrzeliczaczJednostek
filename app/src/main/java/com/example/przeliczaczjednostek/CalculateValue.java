package com.example.przeliczaczjednostek;

public class CalculateValue {
    static final double YARD = 1.093613;
    static final double FEET = 3.280839895;
    static final double INCH = 39.370;
    static final double MILEM = 0.00054;
    static final double MILEL = 0.0006215;
    static final double KARAT = 5;
    static final double FUNT = 2.2;
    static final double UNCJA = 35.27;
    static final double LUT = 564.38;
    static final double CETNARM = 0.022;
    static final double CETNARD = 0.0197;

    private double meter;
    private double yard;
    private double feet;
    private double inch;
    private double mileL;
    private double mileM;
    private double kgram;
    private double karat;
    private double funt;
    private double uncja;
    private double lut;
    private double cetnarM;
    private double cetnarD;

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

    public void calculateKGram(double value) {
        this.kgram = value;
        this.karat = value * KARAT;
        this.funt = value * FUNT;
        this.uncja = value * UNCJA;
        this.lut = value * LUT;
        this.cetnarD = value * CETNARD;
        this.cetnarM = value * CETNARM;
    }

    public void calculateKarat(double value) {
        this.karat = value;
        this.kgram = value / KARAT;
        this.funt = value * FUNT;
        this.uncja = value * UNCJA;
        this.lut = value * LUT;
        this.cetnarD = value * CETNARD;
        this.cetnarM = value * CETNARM;
    }

    public void calculateFunt(double value) {
        this.funt = value;
        this.kgram = value / FUNT;
        this.karat = value * KARAT;
        this.uncja = value * UNCJA;
        this.lut = value * LUT;
        this.cetnarD = value * CETNARD;
        this.cetnarM = value * CETNARM;
    }

    public void calculateUncja(double value) {
        this.uncja = value;
        this.kgram = value / UNCJA;
        this.karat = value * KARAT;
        this.funt = value * FUNT;
        this.lut = value * LUT;
        this.cetnarD = value * CETNARD;
        this.cetnarM = value * CETNARM;
    }

    public void calculateLut(double value) {
        this.lut = value;
        this.kgram = value / LUT;
        this.karat = value * KARAT;
        this.funt = value * FUNT;
        this.uncja = value * UNCJA;
        this.cetnarD = value * CETNARD;
        this.cetnarM = value * CETNARM;
    }

    public void calculateCetnarM(double value) {
        this.cetnarM = value;
        this.kgram = value / CETNARM;
        this.karat = value * KARAT;
        this.funt = value * FUNT;
        this.uncja = value * UNCJA;
        this.lut = value * LUT;
        this.cetnarM = value * CETNARM;
    }

    public void calculateCetnarD(double value) {
        this.cetnarD = value;
        this.kgram = value / CETNARD;
        this.karat = value * KARAT;
        this.funt = value * FUNT;
        this.uncja = value * UNCJA;
        this.lut = value * LUT;
        this.cetnarM = value * CETNARM;
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

    public double getKgram() {
        return kgram;
    }

    public double getKarat() {
        return karat;
    }

    public double getFunt() {
        return funt;
    }

    public double getUncja() {
        return uncja;
    }

    public double getLut() {
        return lut;
    }

    public double getCetnarM() {
        return cetnarM;
    }

    public double getCetnarD() {
        return cetnarD;
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
        } else if (unit.equals("kgram")) {
            calculateKGram(value);
        } else if (unit.equals("karat")) {
            calculateKarat(value);
        } else if (unit.equals("funt")) {
            calculateFunt(value);
        } else if (unit.equals("uncja")) {
            calculateUncja(value);
        } else if (unit.equals("lut")) {
            calculateLut(value);
        } else if (unit.equals("centarM")) {
            calculateCetnarM(value);
        } else if (unit.equals("centarD")) {
            calculateCetnarD(value);
        }
    }
}
