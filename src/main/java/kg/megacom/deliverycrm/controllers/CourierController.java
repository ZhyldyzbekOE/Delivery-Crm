package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.dao.CourierDAO;
import kg.megacom.deliverycrm.enums.CourierStatus;
import kg.megacom.deliverycrm.models.Admin;
import kg.megacom.deliverycrm.models.Courier;
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
    CourierDAO courierDAO;

    @GetMapping({"/courier-table"})
    public String showCourierList(Model model) {
        model.addAttribute("courier", new Courier());
        return "courier";
    }

    @PostMapping("/create-courier")
    public String createNewCourier(@ModelAttribute("courier") Courier courier, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "courier-table";
        }
        courierDAO.saveNewCourier(courier);
        model.addAttribute(new Courier());
        model.addAttribute("courierStatus",CourierStatus.values());


        return "redirect:/courierTable";
    }

    @GetMapping("/courierTable")
    public String getAdminTable(Model model){
        model.addAttribute("couriers", courierDAO.getAllCouriers());


        return "courierTable";
    }

    @GetMapping("/deleteCourier/{id}")
    public String deleteCourierFromDb(@PathVariable("id") Long id){
        courierDAO.deleteFromDbCourier(id);
        return "redirect:/courierTable";
    }

    @GetMapping("/editCourier/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        System.out.println(courierDAO.getCourierByIdForEdit(id));
        model.addAttribute("courier", courierDAO.getCourierByIdForEdit(id));
        return "updateCourierTestPage";
    }

    @PostMapping("/updateCourier/{id}")
    public String updateCourierForm(@PathVariable("id") Long id, @ModelAttribute("admin") @Valid Courier courier,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "updateCourierTestPage";
        }

        courierDAO.update(id, courier);
        return "redirect:/courierTable";
    }








}
