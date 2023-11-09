package org.example.model;

import org.example.initializers.annotations.Creatable;
import org.example.initializers.annotations.FieldValue;

//@Creatable
public class Car {

    //@FieldValue(intValue = 12)
    int carId;

    //@FieldValue(stringValue = "GD00001")
    String regNumber;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
