package kg.megacom.deliverycrm.services;

import kg.megacom.deliverycrm.models.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    void saveOrder(Order order);

    Order getOrderByIdForEdit(Long id);

    void updateOldOrderById(Long id, Order order);

    void deleteOrder(Long id);
}
