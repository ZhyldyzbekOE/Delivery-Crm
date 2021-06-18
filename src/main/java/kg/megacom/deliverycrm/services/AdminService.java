package kg.megacom.deliverycrm.services;

import kg.megacom.deliverycrm.models.Admin;
import java.util.List;

public interface AdminService {

    boolean checkLoginAndPasswordAdmin(Admin admin);

    void saveNewAdmin(Admin admin);

    List<Admin> getAllAdmins();

    void deleteFromDbAdmin(Long id);

    Admin getAdminByIdForEdit(Long id);

    void update(Long id, Admin admin);

}
