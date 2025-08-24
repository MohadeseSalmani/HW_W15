package QU_1.Model;

import jakarta.persistence.Embeddable;

@Embeddable

public class Registration {

private int plateNumber ;
private int registrationDate;
private String state;

    public Registration(int plateNumber, int registrationDate, String state) {
        this.plateNumber = plateNumber;
        this.registrationDate = registrationDate;
        this.state = state;
    }
    public  Registration (){}

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(int registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
