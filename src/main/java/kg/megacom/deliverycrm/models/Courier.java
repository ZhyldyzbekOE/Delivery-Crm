package kg.megacom.deliverycrm.models;

import kg.megacom.deliverycrm.enums.CouriersStatus;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "couriers")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String firstName;
    @NotEmpty
    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String lastName;
    @Size(min = 5, message = "Номер должен состоять минимум из 5 цифр")
    @Size(max = 15, message = "Номер должен состоять максимум из 15 цифр")
    @Pattern(regexp = "[0-9]*", message = "Номер должен состоять только из цифр")
    @NotEmpty
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private CouriersStatus courierStatus;

    public Courier() {
    }

    public Courier(String firstName, String lastName, String phoneNumber, CouriersStatus courierStatus) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                ", PhoneNumber=" + phoneNumber +
                ", courierStatus=" + courierStatus +
                '}';
    }
}