package com.atamertc.sabah.compositeSerialization;

import java.io.Serializable;

public class Motor2 implements Serializable {
    int motorNo;

    public Motor2(int motorNo) {
        this.motorNo = motorNo;
    }

    public int getMotorNo() {
        return motorNo;
    }

    public void setMotorNo(int motorNo) {
        this.motorNo = motorNo;
    }

    @Override
    public String toString() {
        return "Motor2 " +
                "motorNo=" + motorNo;
    }
}
