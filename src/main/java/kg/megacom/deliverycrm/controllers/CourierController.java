package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.dao.CourierDAO;
import kg.megacom.deliverycrm.models.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourierController {

    @Autowired
    CourierDAO courierDAO;

    @GetMapping({"/courier-table"})
    public String showUserList( Model model) {
        model.addAttribute("courier", new Courier());
        return "courier";
    }

//    private final CourierDAO courierDAO;
//
//    @Autowired
//    public CourierController(CourierDAO courierDAO) {
//        this.courierDAO = courierDAO;
//    }
//
//    @GetMapping("/indexx")
//    public String index(Model model){
//        //Получим всех людей из DAO и перерадим в обоброжение в предстовление
//        model.addAttribute("couriers",courierDAO.index());
//
//        return "courier";
//    }
//    @GetMapping("/show/{id}")
//    public String show(@PathVariable("id") int id, Model model){
//        //Получим одного человека по id из DAO и передадим на отобродения в представление
//        model.addAttribute("courier",courierDAO.show(id));
//        return "show";
//    }
//
//    @GetMapping("/new")
//    public String newCar(Model model){
//        model.addAttribute("courier",new Courier());
//        return "new";
//    }
//
//    @PostMapping("/new")
//    public String create(@ModelAttribute("courier")Courier courier){
//        courierDAO.save(courier);
//        return "redirect:/index";
//    }





}
