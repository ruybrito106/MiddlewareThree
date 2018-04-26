package com.company.distribution;

public class Calculator {

    private float fstOperand;
    private float sndOperand;

    public Calculator(float fstOperand, float sndOperand) {
        this.fstOperand = fstOperand;
        this.sndOperand = sndOperand;
    }

    public float Add() {
        return fstOperand + sndOperand;
    }

    public float Sub() {
        return fstOperand - sndOperand;
    }

    public float Mul() {
        return fstOperand * sndOperand;
    }

    public float Div() {
        return fstOperand / sndOperand;
    }

}
