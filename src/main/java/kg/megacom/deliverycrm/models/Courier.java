package kg.megacom.deliverycrm.models;

import kg.megacom.deliverycrm.enums.CourierStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
//    @NotEmpty
//    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String firstName;
//    @NotEmpty
//    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String lastName;
//    @NotEmpty()
    private int phoneNumber;
    @Column(name = "courier_status", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private CourierStatus courierStatus;

    public Courier() {
    }

    public Courier( String firstName, String lastName, int phoneNumber, CourierStatus courierStatus) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", courierStatus=" + courierStatus +
                '}';
    }
}
