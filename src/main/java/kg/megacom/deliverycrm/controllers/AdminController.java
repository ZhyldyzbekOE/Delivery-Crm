package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.dao.AdminDAO;
import kg.megacom.deliverycrm.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;

    @GetMapping("/index")
    public String signIn(Model model){
        model.addAttribute("admin", new Admin());
        return "authorization";
    }

    @PostMapping("/admin")
    public String adminIn(@ModelAttribute("admin") Admin admin){
        if (adminDAO.checkLoginAndPasswordAdmin(admin)){
            return "test";
        }
        return "redirect:/index";
    }

}
