package kg.megacom.deliverycrm.models;

import javax.persistence.*;

@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private int PhoneNumber;
    private CourierStatus courierStatus;

    public Courier() {
    }

    public Courier(Long id, String name, int phoneNumber, CourierStatus courierStatus) {
        this.id = id;
        this.name = name;
        PhoneNumber = phoneNumber;
        this.courierStatus = courierStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
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
                ", name='" + name + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", courierStatus=" + courierStatus +
                '}';
    }

    public enum CourierStatus {

        OnMyWay,
        Free,
        OnHoliday

    }
}
