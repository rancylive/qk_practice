package practice.quikr.p_hibernate_em.sellerOnboarding.dto;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class CityDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public String getGstn() {
        return gstn;
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
