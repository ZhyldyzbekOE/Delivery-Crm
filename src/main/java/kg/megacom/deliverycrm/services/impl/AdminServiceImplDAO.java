package kg.megacom.deliverycrm.services.impl;
import kg.megacom.deliverycrm.dao.AdminRepository;
import kg.megacom.deliverycrm.models.Admin;
import kg.megacom.deliverycrm.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplDAO implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
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

    @Override
    public void saveNewAdmin(Admin admin) {
        adminRepository.saveAndFlush(admin);
    }

    @Override
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    @Override
    public void deleteFromDbAdmin(Long id){
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getAdminByIdForEdit(Long id){
        Optional<Admin> adminOptional = adminRepository.findById(id);
        return adminOptional.orElse(null);
    }

    @Override
    public void update(Long id, Admin admin) {
        String name = admin.getFirstName();
        String fam = admin.getLastName();
        String login = admin.getLogin();
        String password = admin.getPassword();
        adminRepository.update(id, name, fam, login, password);
    }

}
