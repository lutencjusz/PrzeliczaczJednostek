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
        this.funt = this.kgram  * FUNT;
        this.uncja = this.kgram  * UNCJA;
        this.lut = this.kgram  * LUT;
        this.cetnarD = this.kgram  * CETNARD;
        this.cetnarM = this.kgram  * CETNARM;
    }

    public void calculateFunt(double value) {
        this.funt = value;
        this.kgram = value / FUNT;
        this.karat = this.kgram  * KARAT;
        this.uncja = this.kgram  * UNCJA;
        this.lut = this.kgram  * LUT;
        this.cetnarD = this.kgram  * CETNARD;
        this.cetnarM = this.kgram  * CETNARM;
    }

    public void calculateUncja(double value) {
        this.uncja = value;
        this.kgram = value / UNCJA;
        this.karat = this.kgram  * KARAT;
        this.funt = this.kgram  * FUNT;
        this.lut = this.kgram  * LUT;
        this.cetnarD = this.kgram  * CETNARD;
        this.cetnarM = this.kgram  * CETNARM;
    }

    public void calculateLut(double value) {
        this.lut = value;
        this.kgram = value / LUT;
        this.karat = this.kgram  * KARAT;
        this.funt = this.kgram  * FUNT;
        this.uncja = this.kgram  * UNCJA;
        this.cetnarD = this.kgram  * CETNARD;
        this.cetnarM = this.kgram  * CETNARM;
    }

    public void calculateCetnarM(double value) {
        this.cetnarM = value;
        this.kgram = value / CETNARM;
        this.karat = this.kgram  * KARAT;
        this.funt = this.kgram  * FUNT;
        this.uncja = this.kgram  * UNCJA;
        this.lut = this.kgram  * LUT;
        this.cetnarM = this.kgram  * CETNARM;
    }

    public void calculateCetnarD(double value) {
        this.cetnarD = value;
        this.kgram = value / CETNARD;
        this.karat = this.kgram  * KARAT;
        this.funt = this.kgram  * FUNT;
        this.uncja = this.kgram  * UNCJA;
        this.lut = this.kgram  * LUT;
        this.cetnarM = this.kgram  * CETNARM;
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
        switch (unit) {
            case "meter":
                calculateMeter(value);
                break;
            case "yard":
                calculateYard(value);
                break;
            case "feet":
                calculateFeet(value);
                break;
            case "inch":
                calculateInch(value);
                break;
            case "mileL":
                calculateMileL(value);
                break;
            case "mileM":
                calculateMileM(value);
                break;
            case "kgram":
                calculateKGram(value);
                break;
            case "karat":
                calculateKarat(value);
                break;
            case "funt":
                calculateFunt(value);
                break;
            case "uncja":
                calculateUncja(value);
                break;
            case "lut":
                calculateLut(value);
                break;
            case "centarM":
                calculateCetnarM(value);
                break;
            case "centarD":
                calculateCetnarD(value);
                break;
        }
    }
}
