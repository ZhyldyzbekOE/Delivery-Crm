package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.enums.CouriersStatus;
import kg.megacom.deliverycrm.enums.OrderStatus;
import kg.megacom.deliverycrm.models.Order;
import kg.megacom.deliverycrm.services.AdminService;
import kg.megacom.deliverycrm.services.CourierService;
import kg.megacom.deliverycrm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CourierService courierService;

    @GetMapping("/newCreateOrderPage")
    public String getPageCreateOrder(Model model){
        model.addAttribute("newOrder", new Order());
        model.addAttribute("admins", adminService.getAllAdmins());
        model.addAttribute("couriers", courierService.getAllCouriers());
        return "createNewOrder";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute("newOrder") @Valid Order order, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("admins", adminService.getAllAdmins());
            model.addAttribute("couriers", courierService.getAllCouriers());
            return "createNewOrder";
        }
        if (order.getCourier().getCourierStatus() != CouriersStatus.Free){
            orderService.changeOrderStatusOnWaiting(order);
            orderService.saveOrder(order);
            return "redirect:/getOrderTable";
        }
        if (order.getCourier() != null){
            courierService.updateStatusOnMyWay(order.getCourier().getFirstName(), order.getCourier().getLastName());
            orderService.saveOrder(order);
            return "redirect:/getOrderTable";
        }
        return null;
    }

    @GetMapping("/editOrder/{id}")
    public String getOrderEditPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("order", orderService.getOrderByIdForEdit(id));
        model.addAttribute("orderStatus", orderService.findAllOrders());
        model.addAttribute("admins", adminService.getAllAdmins());
        model.addAttribute("couriers", courierService.getAllCouriers());
        return "updateOrder";
    }

    @PostMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute("order") Order order){
        if (order.getOrderStatus() == OrderStatus.IN_PROCESS){
            courierService.updateStatusInProcess(order.getCourier().getFirstName(), order.getCourier().getLastName());
            orderService.updateOldOrderById(id, order);
            return "redirect:/getOrderTable";
        }
        if (order.getOrderStatus() == OrderStatus.CANCELED | order.getOrderStatus() == OrderStatus.COMPLETED){
            courierService.updateStatusCanceled(order.getCourier().getFirstName(), order.getCourier().getLastName());
            orderService.updateOldOrderById(id, order);
            return "redirect:/getOrderTable";
        }else {
            orderService.updateOldOrderById(id, order);
            return "redirect:/getOrderTable";
        }
    }


    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") Long id){
        Order order = orderService.getOrderByIdForEdit(id);
        courierService.updateStatusCanceled(order.getCourier().getFirstName(), order.getCourier().getLastName());
        orderService.deleteOrder(id);
        return "redirect:/getOrderTable";
    }
}
