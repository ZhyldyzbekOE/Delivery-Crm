package kg.megacom.deliverycrm.models;

import kg.megacom.deliverycrm.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderName;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    private Double ransomSum;

    private Double deliveryPrice;

    private String orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_address_id")
    private Address fromAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_address_id")
    private Address toAddress;

    // Persists сохроняет и дочерние классы

    public Order() { }

    public Order(String orderName, Double ransomSum, Double deliveryPrice, OrderStatus orderStatus, Address fromAddress, Address toAddress, Courier courier, Admin admin) {
        this.orderName = orderName;
        this.ransomSum = ransomSum;
        this.deliveryPrice = deliveryPrice;
        this.orderStatus = orderStatus;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.courier = courier;
        this.admin = admin;
    }

    public Order(String orderName, Double ransomSum, Double deliveryPrice, OrderStatus orderStatus, Address fromAddress, Address toAddress) {
        this.orderName = orderName;
        this.ransomSum = ransomSum;
        this.deliveryPrice = deliveryPrice;
        this.orderStatus = orderStatus;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Double getRansomSum() {
        return ransomSum;
    }

    public void setRansomSum(Double ransomSum) {
        this.ransomSum = ransomSum;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", courier=" + courier +
                ", admin=" + admin +
                ", ransomSum=" + ransomSum +
                ", deliveryPrice=" + deliveryPrice +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", fromAddress=" + fromAddress +
                ", toAddress=" + toAddress +
                '}';
    }
}
