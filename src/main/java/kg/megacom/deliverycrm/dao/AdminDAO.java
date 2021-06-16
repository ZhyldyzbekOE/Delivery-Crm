package kg.megacom.deliverycrm.dao;
import kg.megacom.deliverycrm.models.Admin;
import kg.megacom.deliverycrm.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdminDAO {

    @Autowired
    private AdminRepository adminRepository;

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

    public void saveNewAdmin(Admin admin) {
        adminRepository.saveAndFlush(admin);
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public void deleteFromDbAdmin(Long id){
        adminRepository.deleteById(id);
    }

    public Admin getAdminByIdForEdit(Long id){
        Optional<Admin> adminOptional = adminRepository.findById(id);
        return adminOptional.orElse(null);
    }

    public void update(Long id, Admin admin) {
        String name = admin.getFirstName();
        String fam = admin.getLastName();
        String login = admin.getLogin();
        String password = admin.getPassword();
        adminRepository.update(id, name, fam, login, password);
    }
}
