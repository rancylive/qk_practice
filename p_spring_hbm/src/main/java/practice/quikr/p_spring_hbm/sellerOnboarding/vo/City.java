package practice.quikr.p_spring_hbm.sellerOnboarding.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class City {
    private int id;
    private String gstn;
    private String name;
    private String address;
    private int pin;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", gstn='" + gstn + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pin=" + pin +
                ", location='" + location + '\'' +
                '}';
    }
}
