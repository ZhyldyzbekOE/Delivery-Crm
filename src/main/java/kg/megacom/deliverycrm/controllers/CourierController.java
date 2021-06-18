package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.enums.CouriersStatus;
import kg.megacom.deliverycrm.models.Courier;
import kg.megacom.deliverycrm.services.CourierService;
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
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping("/getCourierTable")
    public String getCourierTable(Model model){
        model.addAttribute("couriers", courierService.getAllCouriers());
        model.addAttribute("newCourier", new Courier());
        System.out.println(courierService.getAllCouriers());
        return "couriersTable";
    }

    @PostMapping("/createCourier")
    public String newCourier(@ModelAttribute("newCourier") Courier courier){
        courier.setCourierStatus(CouriersStatus.Free);
        courierService.saveCourier(courier);
        return "redirect:/getCourierTable";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourier(@PathVariable("id") Long id){
        courierService.deleteCourier(id);
        return "redirect:/getCourierTable";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        System.out.println(courierService.getCourierByIdForEdit(id));
        model.addAttribute("courier", courierService.getCourierByIdForEdit(id));
        return "updateCourier";
    }

    @PostMapping("/updateCourier/{id}")
    public String updateCourierForm(@PathVariable("id") Long id, @ModelAttribute("courier") @Valid Courier courier,
                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "updateCourier";
        }
        courierService.update(id, courier);
        return "redirect:/couriersTable";
    }
}
