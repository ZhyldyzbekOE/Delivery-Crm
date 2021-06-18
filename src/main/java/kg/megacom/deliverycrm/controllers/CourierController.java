package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping("/getCourierTable")
    public String getCourierTable(){
        return "couriersTable";
    }

}
