package kg.megacom.deliverycrm.controllers;

import kg.megacom.deliverycrm.services.AdminService;
import kg.megacom.deliverycrm.models.Admin;
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
public class AdminController {

    @Autowired
    private AdminService adminService;

    // отрисовка окна авторизация
    @GetMapping("/index")
    public String signIn(Model model){
        model.addAttribute("admin", new Admin());
        return "authorization";
    }

    // проверка логина и пароля для входа
    @PostMapping("/admin")
    public String adminIn(@ModelAttribute("admin") Admin admin, Model model){
        if (adminService.checkLoginAndPasswordAdmin(admin)){
            model.addAttribute("newAdmin", new Admin());
            // вот тут прежде чем вернуть order нужно вытащить из базы
            // пока этот метод не реализован
            return "order";
        }
        return "redirect:/index";
    }

    @GetMapping("/getOrderTable")
    public String getOrderTable(Model model){
        // нужно в  model.addAttribute положить все orders и вывести на экран
        // пока этот метод не реализован
        return "order";
    }

    @PostMapping("/createAdmin")
    public String createNewAdmin(@ModelAttribute("newAdmin") @Valid Admin admin, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "adminsTable";
        }
        adminService.saveNewAdmin(admin);
        return "redirect:/adminTable";
    }

    @GetMapping("/adminTable")
    public String getAdminTable(Model model){
        model.addAttribute("admins", adminService.getAllAdmins());
        model.addAttribute("newAdmin", new Admin());
        return "adminsTable";
    }

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdminFromDb(@PathVariable("id") Long id){
        adminService.deleteFromDbAdmin(id);
        return "redirect:/adminTable";
    }

    @GetMapping("/editAdmin/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        System.out.println(adminService.getAdminByIdForEdit(id));
        model.addAttribute("admin", adminService.getAdminByIdForEdit(id));
        return "updateAdminTestPage";
    }

    @PostMapping("/updateAdmin/{id}")
    public String updateAdminForm(@PathVariable("id") Long id, @ModelAttribute("admin") @Valid Admin admin,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "updateAdminTestPage";
        }
        adminService.update(id, admin);
        return "redirect:/adminTable";
    }
}
