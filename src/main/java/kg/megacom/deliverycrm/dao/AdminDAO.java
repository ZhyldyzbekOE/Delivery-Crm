package kg.megacom.deliverycrm.dao;
import kg.megacom.deliverycrm.controllers.AdminController;
import kg.megacom.deliverycrm.models.Admin;
import kg.megacom.deliverycrm.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDAO {

    @Autowired
    private AdminRepository adminRepository;

//    public ArrayList<Admin> adminArrayList = new ArrayList<>();
//    {
//        adminArrayList.add(new Admin("zheka@gmail.com", "123"));
//    }

    public boolean checkLoginAndPasswordAdmin(Admin admin){

        List<Admin> adminArrayList = adminRepository.findAll(); // это select для бд

        for (Admin item : adminArrayList) {
            if (item.getLogin().equals(admin.getLogin())
                    && item.getPassword().equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
