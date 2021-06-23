package kg.megacom.deliverycrm.services.impl;

import kg.megacom.deliverycrm.dao.OrderRepository;
import kg.megacom.deliverycrm.models.Order;
import kg.megacom.deliverycrm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplDAO implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrderByIdForEdit(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()){
            Order order1 = null;
            order1 = order.get();
            return order1;
        }
        return null;
    }

    @Override
    public void updateOldOrderById(Long id, Order order) {
        Order order1 = getOrderByIdForEdit(id);
        order1.setOrderName(order.getOrderName());
        order1.setCourier(order.getCourier());
        order.setAdmin(order.getAdmin());
        order1.setRansomSum(order.getRansomSum());
        order1.setDeliveryPrice(order.getDeliveryPrice());
        order1.setOrderStatus(order.getOrderStatus());
        order1.setFromAddress(order.getFromAddress());
        order1.setToAddress(order.getToAddress());
        orderRepository.save(order1);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
