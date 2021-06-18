package kg.megacom.deliverycrm.models;

import kg.megacom.deliverycrm.enums.CouriersStatus;
import javax.persistence.*;

@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int  PhoneNumber;
    @Enumerated(EnumType.STRING)
    private CouriersStatus courierStatus;

    public Courier() {
    }

    public Courier(String firstName, String lastName, int phoneNumber, CouriersStatus courierStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        PhoneNumber = phoneNumber;
        this.courierStatus = courierStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public CouriersStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CouriersStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", courierStatus=" + courierStatus +
                '}';
    }
}