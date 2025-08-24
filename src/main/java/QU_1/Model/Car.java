package QU_1.Model;

import jakarta.persistence.Entity;

import java.util.List;

import static java.util.Arrays.stream;

@Entity
public class Car extends Vehicle {

    private int seatingCapacity;
    private String fuelType;

    public Car(int seatingCapacity, String fuelType) {
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }
    public Car() {}


    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }



}
