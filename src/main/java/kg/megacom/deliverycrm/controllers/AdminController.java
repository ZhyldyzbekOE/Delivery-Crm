package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.dao.AdminDAO;
import kg.megacom.deliverycrm.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;

    // отрисовка окна авторизация
    @GetMapping("/index")
    public String signIn(Model model){
        model.addAttribute("admin", new Admin());
        return "authorization";
    }

    // проверка логина и пароля для входа
    @PostMapping("/admin")
    public String adminIn(@ModelAttribute("admin") Admin admin, Model model){
        if (adminDAO.checkLoginAndPasswordAdmin(admin)){
            model.addAttribute("newAdmin", new Admin());
            return "order";
        }
        return "redirect:/index";
    }

    @PostMapping("/createAdmin")
    public String createNewAdmin(@ModelAttribute("newAdmin") @Valid Admin admin, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "order";
        }
        adminDAO.saveNewAdmin(admin);
        return "test";
    }


}
